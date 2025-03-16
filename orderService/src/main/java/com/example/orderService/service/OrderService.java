package com.example.orderService.service;

import com.example.orderService.dto.OrderRequest;
import com.example.orderService.model.Order;
import com.example.orderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public void placeOrder(OrderRequest orderRequest){
//        mapping orderRequest to orderObject
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);

    }
}
