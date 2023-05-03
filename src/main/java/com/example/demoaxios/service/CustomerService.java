package com.example.demoaxios.service;

import com.example.demoaxios.model.Customers;
import com.example.demoaxios.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customers> findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customers save(Customers customers) {
        return customerRepository.save(customers);
    }

    @Override
    public void remote(long id) {
        customerRepository.deleteById(id);
    }
}
