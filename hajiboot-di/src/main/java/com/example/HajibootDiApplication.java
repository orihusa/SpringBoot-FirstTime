// 2.1.4 コンポーネント・スキャンで自動Bean登録

package com.example;

import com.example.app.Frontend;	// 2.1.3
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Import;	// 2.1.4 削除

@EnableAutoConfiguration	// Spring Bootの自動設定を有効にするためのアノテーション [2.1.2]
@ComponentScan				// 2.1.4  このクラスと同じパッケージ以下のクラスを走査する
// @Import(AppConfig.class)	// 2.1.4 削除 

//Spring Boot 1.2 からは
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
//の、上記３つを合成した「@SpringBootApplication」アノテーションを使用する。

public class HajibootDiApplication {

	public static void main(String[] args) {
		// SpringApplication.runで、Spring Bootアプリケーションを起動
		// このメソッドの戻り値は、DIコンテナの本体であるApplicationContextとなる
		ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);
		
		Frontend frontend = context.getBean(Frontend.class);
		frontend.run();
	}
}
