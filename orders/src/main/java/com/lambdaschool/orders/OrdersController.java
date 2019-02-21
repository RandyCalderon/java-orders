package com.lambdaschool.orders;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repository.AgentRepository;
import com.lambdaschool.orders.repository.CustomerRepository;
import com.lambdaschool.orders.repository.OrderRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/agents")
    public List<Agent> findagent() {
        return agentrepos.findAll();
    }

    @GetMapping("/agents/agentcode/{agentcode}")
    public Agent findagentId(@PathVariable long agentcode) {
        var foundAgent = agentrepos.findById(agentcode);
        if (foundAgent.isPresent()) {
            return foundAgent.get();
        } else {
            return null;
        }
    }

    @PostMapping("/agents")
    public Agent addAgent(@RequestBody Agent agent) throws URISyntaxException {
        return agentrepos.save(agent);
    }

    @DeleteMapping("/agents/agentcode/{agentcode}")
    public Agent deleteAgent(@PathVariable long agentcode) {
        var foundAgent = agentrepos.findById(agentcode);
        if (foundAgent.isPresent()) {
            agentrepos.deleteById(agentcode);
            return foundAgent.get();
        } else {
            return null;
        }
    }

    // Customer

    // Working
    @GetMapping("/customers")
    public List<Customer> findcust() {
        return custrepos.findAll();
    }

    // Working
    @GetMapping("/customers/custcode/{custcode}")
    public Customer findcustId(@PathVariable long custcode) {
        var foundCust = custrepos.findById(custcode);
        if (foundCust.isPresent()) {
            return foundCust.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) throws URISyntaxException {
        return custrepos.save(customer);
    }

    @PutMapping("/customers/custocode/{custcode}")
    public Customer changeCust(@RequestBody Customer newcust, @PathVariable long custcode) throws URISyntaxException {
        Optional<Customer> updateCust = custrepos.findById(custcode);
        if (updateCust.isPresent()) {
           newcust.setCustcode(custcode);
           custrepos.save(newcust);

           return newcust;
        } else {
            return null;
        }
    }

    // Working
    @DeleteMapping("/customers/custcode/{custcode}")
    public Customer deleteCustomer(@PathVariable long custcode) {
        var foundCust = custrepos.findById(custcode);
        if (foundCust.isPresent()) {
            custrepos.deleteById(custcode);
            return foundCust.get();
        } else {
            return null;
        }
    }

    // Order

    // Working
    @GetMapping("/orders")
    public List<Order> findorder() {
        return ordrepos.findAll();
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) throws URISyntaxException {
        return ordrepos.save(order);
    }

    // Working
    // why did ordernum not work but ordnum did? for the endpoint
    @DeleteMapping("/orders/ordnum/{ordnum}")
    public Order deleteOrder(@PathVariable long ordnum) {
        var foundOrder = ordrepos.findById(ordnum);
        if (foundOrder.isPresent()) {
          ordrepos.deleteById(ordnum);
          return foundOrder.get();
        } else {
            return null;
        }
    }
}
