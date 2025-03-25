package com.example.orderService.service;

import com.example.orderService.client.InventoryClient;
import com.example.orderService.dto.OrderRequest;
import com.example.orderService.model.Order;
import com.example.orderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }


    public void placeOrder(OrderRequest orderRequest){
        if(!inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity()))
            throw new RuntimeException("Product with skucode " + orderRequest.skuCode() + " is not in stock for quantity " + orderRequest.quantity());

//        mapping orderRequest to orderObject
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);

    }
}
