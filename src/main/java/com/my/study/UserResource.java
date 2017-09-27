package com.my.study;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.study.model.User;

@RestController
@RequestMapping("/users")
public class UserResource  {

	private UserRepositary userRepositary;

	@Autowired
	public UserResource(UserRepositary userRepositary) {
		super();
		this.userRepositary = userRepositary;
	}

	@GetMapping("/add/{id}/{name}")

	public User addUser(@PathVariable("id") String id, @PathVariable("name") String name) {

		userRepositary.saveUser(new User(id, name, 20000l));
		return userRepositary.findByUser(id);

	}
	
	@GetMapping("/update/{id}/{name}")

	public User updateUser(@PathVariable("id") String id, @PathVariable("name") String name) {

		userRepositary.updateUser(new User(id, name, 20000l));
		return userRepositary.findByUser(id);

	}
	
	@GetMapping("/delete/{id}")

	public void deleteUser(@PathVariable("id") String id) {
		userRepositary.deleteUser(id);
	}
	
	
	@GetMapping("/all")
	
	public Map<String,User> findall(){
		return userRepositary.findall();
	}
	
	
}
