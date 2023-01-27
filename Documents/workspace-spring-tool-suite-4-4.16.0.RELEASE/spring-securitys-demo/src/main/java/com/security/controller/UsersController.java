package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Users;
import com.security.serviceImpl.UsersServiceimpl;

@RestController
//@RequestMapping("/user")
public class UsersController {
	@Autowired
	private UsersServiceimpl serviceimpl;

//@PreAuthorize("hasRole('normal')") 
	@GetMapping("/getuser")
	public List<Users> getAllUsers() {
		return serviceimpl.getAllUsers();
	}

	@GetMapping("/getUsers/{id}")
	public Users getUsersById(@PathVariable int id) throws Exception {

		return serviceimpl.getById(id);
	}

	@PostMapping("/addusers")
	public String addUsers(@RequestBody Users user) {
		serviceimpl.postData(user);
		return "Users Added";
	}

	@PutMapping("/updateusers/{id}")
	public String updateUsers(@PathVariable int id, @RequestBody Users users) {
		serviceimpl.putdata(id, users);
		return "Users updated";

	}

	@DeleteMapping("/deleteusers/{id}")
	public String deleteUsers(@PathVariable int id) {
		serviceimpl.DeleteById(id);
		return "Users deleted";
	}
}
