package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordernum;

    private double ordamount;

    private double advanceamount;


    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agent agent;

    private String orddescription;

    public Order() {}

    public long getOrdernum() {
        return ordernum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }

}
