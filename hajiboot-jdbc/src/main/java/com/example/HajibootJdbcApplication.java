package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		// ＤＢ動作確認用SQL
		String sql = "SELECT 1";

		// SQLに埋め込むパラメータを作る（今回は埋め込みデータが無い為、空オブジェクトとする）
		SqlParameterSource param = new MapSqlParameterSource();

		// クエリの実行結果をオブジェクトに変換して取得する
		Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);
		
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJdbcApplication.class, args);
	}
}
