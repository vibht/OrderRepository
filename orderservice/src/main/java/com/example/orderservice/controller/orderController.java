package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.models.Order;
import com.example.orderservice.service.orderService;

@RestController
@RequestMapping("/api/v1/order")
public class orderController {
    @Autowired
    private orderService service;


    @PostMapping("/saveOrder")
    public ResponseEntity<Order> orderPlaced(@RequestBody Order order) {
        Order orderPlace = service.orderPlaced(order);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderPlace);

    }
}
