package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.Userrepository;

@Service
public class Userservice {
	@Autowired
	private Userrepository userrepository;
	public List<User> getuser() {
		return (List<User>) userrepository.findAll();
	}
}
