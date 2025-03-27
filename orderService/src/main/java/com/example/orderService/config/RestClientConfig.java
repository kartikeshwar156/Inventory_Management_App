package com.example.orderService.config;

import com.example.orderService.client.InventoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

//    below @value is used to take value from application.properties file
    @Value("${inventory.url}")
    private String inventoryServiceURL;

    // below function will bind with the interface we have defined in "InventoryClient" inside client
    // folder
    @Bean
    public InventoryClient inventoryClient(){
        RestClient restClient = RestClient.builder().baseUrl(inventoryServiceURL).build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();

        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }


}
