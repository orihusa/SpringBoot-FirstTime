// 2.1.2
package com.example.app;

import java.io.InputStream;
import java.util.Scanner;

// 引数を取得するクラス
public class ScannerArgumentResolver implements ArgumentResolver {
	@Override
	public Argument resolve(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		return new Argument(a, b);
	}
}