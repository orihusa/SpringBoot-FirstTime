// 2.1.1
package com.example.app;

// 足し算を行うクラス
public class AddCalculator implements Calculator {
	@Override
	public int calc(int a, int b) {
		return a + b;
	}
}
