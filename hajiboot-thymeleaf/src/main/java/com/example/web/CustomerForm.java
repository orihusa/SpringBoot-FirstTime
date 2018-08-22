/**
 * 更新用フォームに対応するクラス
 * HTMLのformタグから送るパラメータをマッピングさせる
 */
package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data	// Lombokのアノテーションを使用し、setter/getterの実装を省略する
public class CustomerForm {
	
	@NotNull	// 入力チェックのアノテーション
	@Size(min = 1, max = 127)	// 文字数制限のアノテーション
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 127)
	private String lastName;
}