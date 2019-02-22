package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double receiveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode") // Nullable = false removed causes put and post to work
    @JsonIgnore
    private Agent agent;

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy = "customer")
    @JsonIgnore
    private Set<Order> orders;

    public Customer()
    {
    }
}