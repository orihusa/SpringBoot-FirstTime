package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner {

	@Autowired
	// NamedParameterJdbcTemplateを使って書き換えたCustomerRepositoryを使用する
//	NamedParameterJdbcTemplate jdbcTemplate;
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Data追加
		Customer created = customerRepository.save(new Customer(null, "Yuki", "Mori"));
		System.out.println(created + " is created!");

		// Data表示
		// listの各データに対して、forEachメソッドの引数に渡されたラムダ式を適用する
		customerRepository.findAll().forEach(System.out::println);

		// System.out::println は、メソッド参照といい、(x) -> {System.out.println(x);} の省略型
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJdbcApplication.class, args);
	}
}
