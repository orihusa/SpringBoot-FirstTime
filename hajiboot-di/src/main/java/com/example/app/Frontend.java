// 2.1.3 オート・ワイヤリング
package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	// 2.1.4 DIコンテナに登録される 
public class Frontend {
	@Autowired	// DIコンテナがインジェクションすべきフィールドであることを示す
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
	public void run() {
		System.out.print("Enter 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}
}