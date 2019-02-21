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

    // Customer
    @GetMapping("/customers")
    public List<Customer> findcust() {
        return custrepos.findAll();
    }

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
           newcust.setId(custcode);
           custrepos.save(newcust);

           return newcust;
        } else {
            return null;
        }
    }

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
    @GetMapping("/orders")
    public List<Order> findorder() {
        return ordrepos.findAll();
    }

}
