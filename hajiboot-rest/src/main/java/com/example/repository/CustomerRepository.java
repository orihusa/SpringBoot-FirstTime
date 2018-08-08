/*
 * JpaRepositoryには、CRUD捜査の為の基本的なメソッドが定義されている
 * リポジトリの作成は、JpaRepositoryを継承したインターフェイスを作ることで利用できる
 */
package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	// JPQLを記述
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	
	List<Customer> findAllOrderByName();
}