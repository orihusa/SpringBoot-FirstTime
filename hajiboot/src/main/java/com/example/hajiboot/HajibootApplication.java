package com.example.hajiboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController	//
public class HajibootApplication {

	@GetMapping("/")	// "/"というパスでアクセスがあった場合にhomeメソッドが呼ばれる
	String home() {
//		return "Hello World!";	// httpレスポンスの記述
		return "Hello Spring Boot!";	// httpレスポンスの記述
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootApplication.class, args);
	}
}
