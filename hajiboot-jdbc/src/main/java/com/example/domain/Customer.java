package com.example.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor	// 全フィールドを引数にもつコンストラクタを生成させる
public class Customer implements Serializable {
	private Integer id;
	private String firstName;
	private String lastName;
}