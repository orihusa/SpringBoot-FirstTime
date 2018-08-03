/*
 * JpaRepositoryには、CRUD捜査の為の基本的なメソッドが定義されている
 * リポジトリの作成は、JpaRepositoryを継承したインターフェイスを作ることで利用できる
 */
package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository  // * 動かないので追加してみた
public interface CustomerRepository extends JpaRepository <Customer, Integer> {
}