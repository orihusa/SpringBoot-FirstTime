package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;

	// a顧客全件取得
	@GetMapping
	List<Customer> getCustomers() {
		List<Customer> customers = customerService.findAll();
		return customers;
	}
	
	// b顧客１件取得
	@GetMapping(path = "{id}")
	Optional<Customer> getCustomer(@PathVariable Integer id) {
		Optional<Customer> customer = customerService.findOne(id);
		return customer;
	}
}