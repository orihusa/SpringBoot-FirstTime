package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
//		// DataSetを名前の昇順で取得する
//		customerRepository.findAllOrderByName().forEach(System.out::println);
//
		// paging処理
		Pageable pageable = new PageRequest(0, 3);	// 取得するPaging情報を用意。コンストラクタの第１引数：ページ数、第２引数：１ページ当りの件数
//		Page<Customer> page = customerRepository.findAll(pageable);	// 指定したページのCustomerデータ取得
		Page<Customer> page = customerRepository.findAllOrderByName(pageable);	// 指定したページのCustomerデータ取得
		//
		System.out.println("１ページのデータ数= " + page.getSize());
		System.out.println("現在のページ = " + page.getNumber());
		System.out.println("全ページ数 = " + page.getTotalPages());
		System.out.println("全データ数 = " + page.getTotalElements());
		page.getContent().forEach(System.out::println);		// 該当ページのデータリストを取得
		
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJpaApplication.class, args);
	}
}
