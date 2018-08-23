package com.example;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenPassword {
	public static void main(String[] args) {
		System.out.printf(new Pbkdf2PasswordEncoder().encode("demo"));
	}
}