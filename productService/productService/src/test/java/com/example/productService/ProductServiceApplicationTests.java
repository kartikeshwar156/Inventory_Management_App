package com.example.productService;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

// below you can see that we want to run this test on random port so that it does't
// conflict with some existing port already running some service
// by default it runs on port 8080

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	// Initializing a MongoDB container (static ensures it starts only once)
	// and
	// Since you are already running a MongoDB Docker container in your docker-compose.yml file
	// and providing credentials in application.properties, using @ServiceConnection in your
	// tests will allow you to create an
	// isolated MongoDB test container without affecting your main MongoDB instance.
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(
			"mongo");

	// this will give the port on which our springBootTest env is running, as we have stated above
	// it's RANDOM_PORT, therefore we are using below line with @LocalServerPort
	// and
	// If you use SpringBootTest.WebEnvironment.RANDOM_PORT,
	// Spring Boot will start on a random available port. Rest Assured needs to match that port.
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;

	}

	// we need to start mongoDB Test Containers before running the tests , so we
	// are adding static blocks.
	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				    "id": "67d553aeecba613437a95d5c",
				    "name": "iphone 15",
				    "description": "this is costly phone",
				    "price": 1000
				}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iphone 15"))
				.body("description", Matchers.equalTo("this is costly phone"))
				.body("price", Matchers.equalTo(1000));
	}

}
