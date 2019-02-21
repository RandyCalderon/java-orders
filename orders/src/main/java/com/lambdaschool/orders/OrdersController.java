package com.lambdaschool.orders;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repository.AgentRepository;
import com.lambdaschool.orders.repository.CustomerRepository;
import com.lambdaschool.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

    @Autowired
    AgentRepository agentrepos;

    @Autowired
    CustomerRepository custrepos;

    @Autowired
    OrderRepository ordrepos;

    // Agent
    @GetMapping("/agent")
    public List<Agent> findagent() {
        return agentrepos.findAll();
    }

    // Customer
    @GetMapping("/customer")
    public List<Customer> findcust() {
        return custrepos.findAll();
    }

    // Order
    @GetMapping("/order")
    public List<Order> findorder() {
        return ordrepos.findAll();
    }
}
