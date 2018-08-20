/**
 * 実習１
 * 依存関係を使った例
 */
/**
 * HelloAppクラスからMessageBeanクラスのcallHelloメソッドを呼び出す
 */
package main.java.basic.hello01;

public class HelloApp {
	
	public static void main(String[] args) {
		// MessageBeanのインスタンスを生成
		MessageBean bean = new MessageBean();
		
		// インスタンス化したbeanからcallHelloメソッドを呼び出す
		bean.callHello("今日は良い天気ですね。");
	}
	/**
	 * MessageBeanクラスが存在しないと、HelloAppクラスは動作しない為、
	 * 「HelloAppクラスはMessageBeanクラスに依存している」という事になる。
	 */
}
/**
 * MessageBeanクラスの内容が大幅に変更された場合、
 * これを利用する側（この実習ではHelloAppクラス）も修正が必要となる。
 * この様な影響を最小限にするのがinterfaceの利用となる。 
 * ⇒実習２に続く
 */