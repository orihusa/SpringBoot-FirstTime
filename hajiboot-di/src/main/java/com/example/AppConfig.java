// 2.1.1
// 2.1.2
// 2.1.3
package com.example;
import com.example.app.AddCalculator;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;
import com.example.app.ScannerArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// このクラスがJavaConfig用である事を示す
public class AppConfig {
	@Bean		// DIコンテナに管理させたいメソッドに付ける
	Calculator calculator() {	// このメソッド名が、Bean名となる
		return new AddCalculator();	//
	}

	@Bean
	ArgumentResolver argumentResolver() {
		return new ScannerArgumentResolver();
	}
	
	@Bean	// 2.1.3
	Frontend frontend() {
		return new Frontend();
	}
}
