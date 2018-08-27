package com.example.hajiboot;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//Spring Bootテストの有効化。RANDOM_PORT：空いているポートに組み込みサーバを立ち上げる。
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HajibootApplicationTests {
	@LocalServerPort
	int port;	// 立ち上がったサーバのポート番号を注入
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"http://localhost:" + port, String.class);
		// TestRestTemplateを使用する場合、「プロトコル://ホスト名:ポート番号」を省略する事ができる
		//ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello World TEST!");
	}
}
