package com.example.productService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

// below you can see that we want to run this test on random port so that it does't
// conflict with some existing port already running some service
// by default it runs on port 8080

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	// Initializing a MongoDB container (static ensures it starts only once)
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(
			"mongo");
	@Test
	void shouldCreateProduct() {
	}

}
