package com.example.springbootmodule2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private Date orderDate;
    private double totalAmount;

    private List<OrderDetails> orderDetails = new ArrayList<>();

    public Order(Customer customer, Date orderDate, double totalAmount) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}
