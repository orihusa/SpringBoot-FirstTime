/**
 * 実習２
 * interfaceを使った例
 */
/**
 * helloAppクラスからmessageBeanクラスのcallHelloメソッドを呼び出す
 * Beanクラスを設計する際は、interfaceを用いるのが基本となる
 * interfaceに定義されるメソッドは、そのinterfaceで具現する全てのクラスで実装される事を保証する
 */
package main.java.basic.hello02;

public class HelloApp {
	
	public static void main(String[] args) {
		// インスタンスを生成
		MessageBeanEn bean = new MessageBeanEn();
//		MessageBeanJa bean = new MessageBeanJa();
		
		// インスタンス化したbeanからcallHelloメソッドを呼び出す
		bean.callHello("今日は良い天気ですね。");
	}
	/**
	 * interfaceには具体的な処理を記述しない。
	 * interfaceは具現したクラス（ここではMessageBeanEnやMessageBeanJa）の詳細を隠し、
	 * interfaceで提供されるメソッド名がそのクラスを利用する為の入り口となる。
	 */
}
/**
 * 通常、interface自体は変更される事が無い。 
 * 利用されるクラスの内容が大幅に変更された場合でも、
 * interfaceの規約に沿っていれば利用する側（この実習ではhelloAppクラス）の修正を最小限に出来る。
 * （インスタンスを生成する箇所を修正しなければならない）
 * ⇒実習３に続く
 */