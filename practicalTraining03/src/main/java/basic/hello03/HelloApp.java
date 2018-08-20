/**
 * 実習３
 * DIを使った例
 */
/**
 * Beanのインスタンスが使われるときは、Spring Frameworkが代わりに依存関係を注入してくれる
 */
package basic.hello03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {

		/**
		 * 必要とされるBeanを、Spring Frameworkに知らせる
		 * src/main/resources/beans.xmlには、使いたいBeanのインスタンス情報を記述しておく
		 * xmlファイルを配置するパスは決められている
		 */

		// Spring Framework内でbeanのインスタンスはBeanFactoryが生成する
		// ApplicationContextはBeanFactoryの拡張版
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/beans.xml"));
		ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
		
		// インスタンスを生成
		// bean.xml内のmessageというidに関連付けられたクラス
		MessageBean bean = app.getBean("message", MessageBean.class);
		
		// インスタンス化したbeanからcallHelloメソッドを呼び出す
		bean.callHello("今日は良い天気ですね。");
	}
}
/**
 * Beanクラスを利用する際、interfaceを用いるのが一般的だが、
 * 使いたいインスタンスを事前に用意して必要な時にそのインスタンスを利用する側に「注入」して使うのが
 * DI(Dependency Injection:依存性注入)となる。
 * Beanのインスタンスが使用される時は、Spring Frameworkが依存関係を注入してくれる。
 * 
 * DIを使った例では、実習１、実習２のソースと比較し、
 * 何か大幅な修正が入った場合でも、Bean.xmlファイルの内容を修正するだけで対応が可能となる。
 * 
 * SpringBootでは、Autowiredとアノテーション（@マークのやつ）を記述することで、自動でDIできる。
 * ⇒実習４に続く
 */
