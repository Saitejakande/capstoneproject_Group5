package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Owner;
import com.example.model.User;
import com.example.repository.OwnerRepository;
import com.example.repository.Userrepository;
import com.example.service.OwnerService;
import com.example.service.Userservice;
@CrossOrigin
@RestController
@RequestMapping("/my")
public class UserController {
	@Autowired
	private Userservice userservice;
	Map<String,User> allusers= new HashMap<>();
	
	@Autowired
	private Userrepository repository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getmethod() {
		List<User> user= repository.findAll();
		return new ResponseEntity<>(user,HttpStatus.OK) ;
		
	}
	@PostMapping("/users")
	public String postmethod(@RequestBody User userdetails) {
		User addvalue= new User();
		addvalue.setUserId(userdetails.getUserId());
		addvalue.setName(userdetails.getName());
		addvalue.setEmail(userdetails.getEmail());
		allusers.put(userdetails.getName(),addvalue);
		
		return"user added";
		
	}@PutMapping(path="/{userId}")
	public String putmethod(@PathVariable String userId ,@RequestBody User userdetails) {
		if(allusers.containsKey(userId)) {
			User addvalue= new User();
			addvalue.setUserId(userdetails.getUserId());
			addvalue.setName(userdetails.getName());
			addvalue.setEmail(userdetails.getEmail());
			allusers.put(userdetails.getName(),addvalue);
			return"updated succesfully";
		}
		else
		return"userId not found";
		
	}@DeleteMapping("/userId")
	public String deletemethod(@PathVariable String userId ) {
		if (allusers.containsKey(userId)) {
			allusers.remove(userId);
			return"user deleted";
		}
		else
		return"userid not found";
		
	}

	@Autowired
	private OwnerService ownerservice;
	Map<String,Owner> allowners= new HashMap<>();
	
	@Autowired
	private OwnerRepository ownerrepository;
	
	@GetMapping("/owners")
	public ResponseEntity<List<Owner>> getmethod1() {
		List<Owner> owner= ownerrepository.findAll();
		return new ResponseEntity<>(owner,HttpStatus.OK) ;
		
	}
	@PostMapping("/owners")
	public String postmethod(@RequestBody Owner ownerdetails) {
		Owner addvalue= new Owner();
		addvalue.setOwnerId(ownerdetails.getOwnerId());
		addvalue.setName(ownerdetails.getName());
		addvalue.setEmail(ownerdetails.getEmail());
		addvalue.setPassword(ownerdetails.getPassword());
		allowners.put(ownerdetails.getName(),addvalue);
		
		return"Owner added";
		
	}@PutMapping(path="/{ownerId}")
	public String putmethod(@PathVariable String ownerId ,@RequestBody Owner ownerdetails) {
		if(allowners.containsKey(ownerId)) {
			Owner addvalue= new Owner();
			addvalue.setOwnerId(ownerdetails.getOwnerId());
			addvalue.setName(ownerdetails.getName());
			addvalue.setEmail(ownerdetails.getEmail());
			addvalue.setPassword(ownerdetails.getPassword());
			allowners.put(ownerdetails.getName(),addvalue);
			return"updated succesfully";
		}
		else
		return"ownerId not found";
		
	}@DeleteMapping("/{ownerId}")
	public String deletemethod(@PathVariable int ownerId ) {
		if (allowners.containsKey(ownerId)) {
			allowners.remove(ownerId);
			return"owner deleted";
		}
		else
		return"ownerid not found";
		
	}

	
	
}
