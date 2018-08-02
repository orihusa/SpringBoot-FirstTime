package com.example.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity						// JPAのエンティティであることを示す
@Table(name = "customers")	// Entityに対応するテーブル名を指定する
@Data
@NoArgsConstructor			// JPAの仕様でEntityクラスには引数の無いデフォルトコンストラクタが必須
							// Lombokでデフォルトコンストラクタを生成する
@AllArgsConstructor	// 全フィールドを引数にもつコンストラクタを生成させる
public class Customer {
	@Id						// Entityの主キーに付ける
	@GeneratedValue			// DBで主キーが自動採番されることを示す
	private Integer id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
}