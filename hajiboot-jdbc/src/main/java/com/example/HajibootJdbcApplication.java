package com.example;

import com.example.domain.Customer;

//import java.sql.ResultSet;
//import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		// SQL内に、プレースホルダを埋め込む
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";

		// SQLに埋め込むパラメータを作る
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", 1);
		
//		// クエリの実行結果をオブジェクトに変換して取得する（マッピングの為、RowMapperを匿名クラスで実装する）
//		Customer result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Customer>() {
//			@Override
//			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
//			}
//		});

		// Java SE 8 から導入されたラムダ式を使用する
		Customer result = jdbcTemplate.queryForObject(sql, param,
				(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"))
		);
		
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJdbcApplication.class, args);
	}
}
