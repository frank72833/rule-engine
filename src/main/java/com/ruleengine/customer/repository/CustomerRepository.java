package com.ruleengine.customer.repository;

import com.ruleengine.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepository {

    private final Map<UUID, Customer> customers;

    public CustomerRepository() {
        this.customers = new HashMap<>();
    }

    public Customer add(final Customer customer) {
        final var id = UUID.randomUUID();
        final var customerToSave = customer.toBuilder()
                .id(id)
                .build();
        this.customers.put(customerToSave.getId(), customerToSave);
        return customerToSave;
    }

    public Optional<Customer> get(final UUID id) {
        return Optional.ofNullable(this.customers.get(id));
    }
}
