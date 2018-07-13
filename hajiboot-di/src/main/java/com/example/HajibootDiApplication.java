// 2.1.1
// 2.1.2
// 2.1.3
package com.example;

//import com.example.app.Argument;
//import com.example.app.ArgumentResolver;
//import com.example.app.Calculator;
import com.example.app.Frontend;	// 2.1.3
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication; デフォルト。ここでは無効化し、個別設定とする。
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

//import java.util.Scanner;	// 2.1.2の実習で不要となる

//@SpringBootApplication	デフォルト設定
@EnableAutoConfiguration	// Spring Bootの自動設定を有効にするためのアノテーション [2.1.2]
@Import(AppConfig.class)	// JavaConfig読み込みの為
public class HajibootDiApplication {

	public static void main(String[] args) {
		// SpringApplication.runで、Spring Bootアプリケーションを起動
		// このメソッドの戻り値は、DIコンテナの本体であるApplicationContextとなる
		ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);
		
// 2.1.2 の実習で削除
//		// Scannerクラスを使って、簡単に標準入力からデータを取得する (2.1.1)
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter 2 numbers like 'a b' : ");
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		scanner.close();
//		Calculator calculator = context.getBean(Calculator.class);
//		int result = calculator.calc(a, b);

// 2.1.2 の実習で追加
// 2.1.3 の実習で削除
//		System.out.print("Enter 2 numbers like 'a b' : ");
//		ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
//		Argument argument = argumentResolver.resolve(System.in); 
//		
//		// getBeanメソッドを用いてDIコンテナからインスタンスを取得
//		// Calculatorの実態はDIコンテナによって解決され、アプリケーションは意識しない
//		Calculator calculator = context.getBean(Calculator.class);
//		int result = calculator.calc(argument.getA(), argument.getB());

//		System.out.println("result = " + result);

// 2.1.3 の実習で追加
		Frontend frontend = context.getBean(Frontend.class);
		frontend.run();
	}
}
