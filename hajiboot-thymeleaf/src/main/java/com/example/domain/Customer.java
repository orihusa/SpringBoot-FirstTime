package com.example.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")	// Entityに対応するテーブル名を指定する
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		// DBで主キーが自動採番されることを示す
	private Integer id;
	
	private String firstName;
	
	private String lastName;

	@ManyToOne(fetch=FetchType.LAZY)	// UserとCustomerを多対１の関係にする
	@JoinColumn(nullable=true, name="username")		// 外部キーのカラム名を指定する
	private User user;
}