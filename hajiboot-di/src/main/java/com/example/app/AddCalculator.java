// 2.1.1 足し算を行うクラス
// 2.1.4
package com.example.app;

import org.springframework.stereotype.Component;	// 2.1.4

@Component	// 2.1.4 DIコンテナに登録される 
public class AddCalculator implements Calculator {
	@Override
	public int calc(int a, int b) {
		return a + b;
	}
}
