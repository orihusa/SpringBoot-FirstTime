// 2.1.2　引数を取得するクラス
package com.example.app;

import org.springframework.stereotype.Component;	// 2.1.4

import java.io.InputStream;
import java.util.Scanner;

@Component	// 2.1.4 DIコンテナに登録される 
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