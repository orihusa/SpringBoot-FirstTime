package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class HajibootJpaApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Data追加
		Customer created = customerRepository.save(new Customer(null, "Yuki", "Mori"));
		System.out.println(created + " is created!");

//		// Data表示
//		customerRepository.findAll().forEach(System.out::println);
//
		// DataSetを名前の昇順で取得する
		customerRepository.findAllOrderByName().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJpaApplication.class, args);
	}
}
