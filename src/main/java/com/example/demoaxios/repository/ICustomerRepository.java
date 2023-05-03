package com.example.demoaxios.repository;

import com.example.demoaxios.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customers, Long> {
}
