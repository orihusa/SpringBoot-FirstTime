package com.example.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
/**
 * Customerクラスには対応するUserクラスのフィールドを追加する。
 * toStringメソッドでcustomersフィールドを表示すると循環参照によってStackOverflowエラーが発生する。
 * その為、Lombokが生成するtoStringメソッドからcustomersフィールドの出力を除外する。
 */
@ToString(exclude="customers")
public class User {

	@Id
	private String username;

	// REST APIでUserクラスをJSON出力する場合にパスワードフィールドを除外する為、@JsonIgnoreを付ける
	@JsonIgnore
	private String encodedPassword;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")	// UserとCustomerを１対多の関係にする
	// cascade=CascadeType.ALL ：Userの永続化操作や削除操作を関連先のCustomerにも伝播させる事が出来る
	// fetch=FetchType.LAZY ：関連するエンティティを遅延ロードさせる事が出来る（既定値）
	// mappedBy ：双方向の関連にする為、関連先（Customerクラス参照）でのプロパティ名（ここではuser）を指定
	private List<Customer> customers;
}