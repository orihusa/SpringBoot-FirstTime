package com.example.repository;

import com.example.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.annotation.PostConstruct;

@Repository
@Transactional	// DBトランザクションの制御を行う
public class CustomerRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	// saveメソッド実行時に、Customerオブジェクトにidがセットされない問題を解消する
	SimpleJdbcInsert insert;
	
	@PostConstruct
	public void init() {
		insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
				.withTableName("customers")			// INSERT のSQLを自動生成する為、テーブル名を明示する
				.usingGeneratedKeyColumns("id");	// AUTO_INCREMENT のカラム名を指定
	}
	
	// SQLの実行結果をJavaオブジェクトのリストとして保持させる仕組み
	private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String firstName = rs.getString("first_Name");
		String lastName = rs.getString("last_Name");
		return new Customer(id, firstName, lastName);
	};
	
	// SQLの実行結果をJavaオブジェクトのリストとして保持させる仕組み
	public List<Customer> findAll() {
//		return new ArrayList<>(customerMap.values());
		List<Customer> customers = jdbcTemplate.query(
				"SELECT id, first_Name, last_Name FROM customers ORDER BY id",
				customerRowMapper);
		return customers;
	}

	public Customer findOne(Integer customerId) {
//		return customerMap.get(customerId);
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
		return jdbcTemplate.queryForObject(
				"SELECT id, first_Name, last_Name FROM customers WHERE id=:id",
				param,
				customerRowMapper);
	}
	
	public Customer save(Customer customer) {
//		return customerMap.put(customer.getId(), customer);
		// 更新用のSqlParameterSource
		// BeanPropertySqlParameterSourceを使うことで、Javaオブジェクトのフィールド名と値をマッピングしてparamに格納
		SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
		
		if (customer.getId() == null) {
//			jdbcTemplate.update(
//					"INSERT INTO customers (first_Name, last_Name) VALUES (:firstName, :lastName)",
//					param);
			Number key = insert.executeAndReturnKey(param);		// 自動採番されたidが返却される
			customer.setId(key.intValue());
		} else {
			jdbcTemplate.update(
					"UPDATE customers SET first_Name=:firstName, last_Name=:lastName WHERE id=:id",
					param);
		}
		return customer;
	}

	public void delete(Integer customerId) {
//		customerMap.remove(customerId);
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
		jdbcTemplate.update(
				"DELETE FROM customers WHERE id=:id",
				param);
	}
}