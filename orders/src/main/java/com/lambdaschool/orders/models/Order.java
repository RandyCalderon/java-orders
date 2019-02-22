package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordernum;

    @ManyToOne
    @JoinColumn(name = "custcode")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "agentcode")
    @JsonIgnore
    private Agent agent;

    private double ordamount;

    private double advanceamount;

    private String orddescription;

    public Order() {}


}
