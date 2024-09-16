package com.odeniz.microservices.order.service;

import com.odeniz.microservices.order.client.InventoryClient;
import com.odeniz.microservices.order.dto.OrderRequest;
import com.odeniz.microservices.order.event.OrderPlacedEvent;
import com.odeniz.microservices.order.model.Order;
import com.odeniz.microservices.order.respoistory.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest){
        var inStock = inventoryClient.isInStock(orderRequest.squCode(), orderRequest.quantity());

        if (inStock){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.squCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
            OrderPlacedEvent event = new OrderPlacedEvent(order.getOrderNumber(), orderRequest.userDetails().getUsername());
            kafkaTemplate.send("order-placed",event);
        }else {
            throw new RuntimeException("Product with SquCode: "+  orderRequest.squCode() + " is not in stock");
        }
    }
}
