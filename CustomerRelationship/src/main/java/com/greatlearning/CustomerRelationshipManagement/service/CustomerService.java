package com.greatlearning.CustomerRelationshipManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.CustomerRelationshipManagement.Customer;

@Service
public interface CustomerService {

	public List<Customer> findAll();

	public void save(Customer thecustomer);

	public Customer findById(int id);

	public void deleteById(int theid);

}
