package com.company.CarRental.customers;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private Map<Long, Customer> customers = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    public CustomerController() {
        Long id = idCounter.incrementAndGet();
        customers.put(id, new Customer(id, "Sergio", 36));
        id = idCounter.incrementAndGet();
        customers.put(id, new Customer(id, "Maria", 25));
    }

    @GetMapping
    public List<Customer> all() {
        return new ArrayList<Customer>(customers.values());
    }

    //CRUD

    //Create - create new customer
    @PostMapping
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        Long id = idCounter.incrementAndGet();
        newCustomer.setId(id);
        customers.put(id, newCustomer);
        return newCustomer;
    }

    //Read - get customer by id / get all customers
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customers.get(id);
    }

    //Update - update one customer by id
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updateData) {
        Customer cust = customers.get(id);

        if (cust == null) {
            return cust;
        }

        if(updateData.getName() != null) {
            cust.setName(updateData.getName());
        }
        if(updateData.getAge() != null) {
            cust.setAge(updateData.getAge());
        }
        return cust;
    }

    //Delete - delete one customer by id
    @DeleteMapping("/{id}")
    public void deleteCustomer (@PathVariable Long id) {
        customers.remove(id);
    }
}
