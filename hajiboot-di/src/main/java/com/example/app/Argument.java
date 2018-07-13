// 2.1.2
package com.example.app;

import lombok.Data;

// 引数オブジェクト
// Data:コンパイル時に、各フィールドのsetter/getter、toStringメソッド、equalsメソッド、hashCodeメソッドが生成される
@Data
public class Argument {
	private final int a;
	private final int b;
}