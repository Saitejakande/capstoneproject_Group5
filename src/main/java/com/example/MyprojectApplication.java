package com.example;

import org.hibernate.annotations.FetchProfile.FetchOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.repository.Userrepository;

@SpringBootApplication
public class MyprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

	@Autowired
	private Userrepository userrepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void run() {
		
	}
	public void run(String... args) throws Exception {
		String sql="set FOREIGN_KEY_CHECKS=0";
		int result=jdbcTemplate.update(sql);
	}
	
	@Bean
	public void insertData(){}
	
	
}
