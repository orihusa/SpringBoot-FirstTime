package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repository.CustomerRepository;

@SpringBootApplication
public class HajibootRestApplication {

	@Autowired
	CustomerRepository customerRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(HajibootRestApplication.class, args);
	}
}
