package com.example.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;



  // get all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}		

	// get user by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	// add user rest api
	@PostMapping("/users")
	public ResponseEntity<Map<String, Boolean>> createUser(@RequestBody User user) {
		userRepository.save(user);

		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Added", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	// update user rest api
	@PutMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));

		user.setId(userDetails.getId());
		user.setUser_name(userDetails.getUser_name());
		user.setName(userDetails.getName());
    user.setLast_Name(userDetails.getLast_Name());
		user.setEmail(userDetails.getEmail());
    user.setAge(userDetails.getAge());
		user.setPassword(userDetails.getPassword());
		user.setIs_active(userDetails.getIs_active());

		userRepository.save(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	// delete user rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
