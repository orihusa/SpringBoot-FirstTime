package com.example.domain;

//import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")	// Entityに対応するテーブル名を指定する
@Data
@NoArgsConstructor			// JPAの仕様でEntityクラスには引数の無いデフォルトコンストラクタが必須
							// Lombokでデフォルトコンストラクタを生成する
@AllArgsConstructor	// 全フィールドを引数にもつコンストラクタを生成させる
public class Customer {
	@Id						// Entityの主キーに付ける
	@GeneratedValue			// DBで主キーが自動採番されることを示す
	private Integer id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
}