package com.example.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;

	// a.顧客全件取得
	@GetMapping
	List<Customer> getCustomers() {
		List<Customer> customers = customerService.findAll();
		return customers;
	}
	
	// b.顧客１件取得
	@GetMapping(path = "{id}")
	Optional<Customer> getCustomer(@PathVariable Integer id) {
		Optional<Customer> customer = customerService.findOne(id);
		return customer;
	}

	// c.新規作成
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	Customer postCustomers(@RequestBody Customer customer) {
//		return customerService.create(customer);
//	}
	ResponseEntity<Customer> PostCustomers(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
		Customer created = customerService.create(customer);
		URI location = uriBuilder.path("api/customers/{id}")
				.buildAndExpand(created.getId()).toUri();
		return ResponseEntity.created(location).body(created);
	}

	// d.顧客1件更新
	@PutMapping(path = "{id}")
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}

	// e.顧客１件削除
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}
}