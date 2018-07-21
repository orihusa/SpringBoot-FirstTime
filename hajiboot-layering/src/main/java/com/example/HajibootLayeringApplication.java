package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@SpringBootApplication
public class HajibootLayeringApplication implements CommandLineRunner {
	@Autowired
	CustomerService customerService;
	
	@Override
	public void run(String... args) throws Exception {
		// データ追加
		customerService.save(new Customer(1, "Nobita", "Nobi"));
		customerService.save(new Customer(2, "Takeshi", "Goda"));
		customerService.save(new Customer(3, "Suneo", "Honekawa"));

		// データ表示
		customerService.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootLayeringApplication.class, args);
	}
}
