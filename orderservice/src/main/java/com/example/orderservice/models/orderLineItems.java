package com.example.orderservice.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "t_order_line_itm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class orderLineItems {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity; 
    

    
}
