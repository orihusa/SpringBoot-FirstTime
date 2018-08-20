package basic.hello03;

public class MessageBeanEn implements MessageBean {
	
	// 入力はinterfaceが担当し、具体的な処理はこのクラスで実装する。
	public void callHello(String message) {
		System.out.println("Hello! " + message);
	}
}
