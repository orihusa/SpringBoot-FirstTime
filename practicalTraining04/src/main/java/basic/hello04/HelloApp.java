/**
 * 実習４
 * DIを使った例２
 */
/**
 * Autowiredとアノテーションを使い、自動でDIさせる
 */
package basic.hello04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

// Componentアノテーション付きクラスを自動検出する
@ComponentScan
public class HelloApp implements CommandLineRunner {	// SpringBootのCommandLineRunnerインターフェイスを利用する

	// DIの自動化
	// Autowiredアノテーションを付けたクラスがDIコンテナで管理される。（オート・ワイヤリング）
	@Autowired
	MessageBean messageBean;

	// CommandLineRunnerのrunメソッド
	@Override
	public void run(String... args) throws Exception {
		// インスタンス化したbeanからcallHelloメソッドを呼び出す
		messageBean.callHello("今日は良い天気ですね。");
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloApp.class, args);
	}
}
/**
 * 使いたいインスタンスを事前に用意して必要な時にそのインスタンスを利用する側に「注入」して使うのが
 * DI(Dependency Injection:依存性注入)となる。
 * Beanのインスタンスが使用される時は、Spring Frameworkが依存関係を注入してくれる。
 * 
 * ここではAutowiredのアノテーションを使用する事でDIの自動化を行い、
 * 実習３で用意したBean.xmlが不要となる。
 * 
 * ComponentScanのアノテーションで、Componentなど特定のアノテーションが付くクラスを検出し、
 * DIコンテナに登録する。（自動bean登録）
 * ここでは、MessageBeanEnクラスにComponentアノテーションを付けている。
 */
