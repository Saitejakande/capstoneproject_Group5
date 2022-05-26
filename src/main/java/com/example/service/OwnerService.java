package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.example.model.Owner;
import com.example.repository.OwnerRepository;
@Service
public class OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	public List<Owner> getowner() {
		return (List<Owner>) ownerRepository.findAll();
	}
}
