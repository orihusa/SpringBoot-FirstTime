// 2.1.2 アプリケーションの抽象化
// 2.1.3 オート・ワイヤリングによるDI
// 2.1.4 コンポーネント・スキャンで自動Bean登録
// 2.1.5 CommandLineRunnerの利用

package com.example;

// 2.1.5
import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot 1.2 からは
//   @EnableAutoConfiguration
//   @Configuration
//   @ComponentScan
// の、上記３つを合成した「@SpringBootApplication」アノテーションを使用する。
@SpringBootApplication
public class HajibootDiApplication implements CommandLineRunner {

	// 2.1.5 Frontendクラスが担っていた役割を移植
	@Autowired	// DIコンテナがインジェクションすべきフィールドであることを示す
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.print("Enter 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		// SpringApplication.runで、Spring Bootアプリケーションを起動
		// このメソッドの戻り値は、DIコンテナの本体であるApplicationContextとなる
		SpringApplication.run(HajibootDiApplication.class, args);
		
		// 2.1.5 削除
		//ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);
		//Frontend frontend = context.getBean(Frontend.class);
		//frontend.run();
	}
}
