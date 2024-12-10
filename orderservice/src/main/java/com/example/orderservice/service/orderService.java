package com.example.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.models.Order;
import com.example.orderservice.models.orderLineItems;
import com.example.orderservice.repository.OrderRepository;

@Service
public class orderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order orderPlaced(Order order) {
        try {

            order.setOrderNumber(UUID.randomUUID().toString());

            List<orderLineItems> orderLineItemsList = order.getOrderLineItemsList();
            if (orderLineItemsList != null && !orderLineItemsList.isEmpty()) {

                RestTemplate restTemplate = new RestTemplate();
                String baseUrl = "http://localhost:8083/getSpecificInventoryFromSkuCode/";

                for (orderLineItems lineItem : orderLineItemsList) {

                    String apiUrl = baseUrl + lineItem.getSkuCode();
                    String responseValue = restTemplate.getForObject(apiUrl, String.class);

                    System.out.println("API Response for SKU " + lineItem.getSkuCode() + ": " + responseValue);
                }
            }

            return orderRepository.save(order);

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while placing the order: " + e.getMessage(), e);
        }
    }

}
