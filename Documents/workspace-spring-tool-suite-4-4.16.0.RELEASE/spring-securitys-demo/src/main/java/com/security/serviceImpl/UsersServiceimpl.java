package com.security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.Users;
import com.security.repo.UsersRepository;
import com.security.service.UsersService;

@Service
public class UsersServiceimpl implements UsersService {

	@Autowired
	private UsersRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Users getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new Exception("Users dosnt exist"));
	}

	@Override
	public Users postData(Users users) {
		Users users2 = new Users();
		users2.setUsername(users.getUsername());
		String pass = users.getPassword();
		String enc = passwordEncoder.encode(pass);
		users2.setPassword(enc);
		users2.setRole(users.getRole());
		repository.save(users2);
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public Users putdata(int id, Users user) {
		// TODO Auto-generated method stub
		Users users2 = repository.findById(id).orElseThrow();
		users2.setUsername(user.getUsername());
		String pass = user.getPassword();
		String enc = passwordEncoder.encode(pass);
		users2.setPassword(enc);
		users2.setRole(user.getRole());
		repository.save(users2);
		return users2;
	}

	@Override
	public void DeleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

}
