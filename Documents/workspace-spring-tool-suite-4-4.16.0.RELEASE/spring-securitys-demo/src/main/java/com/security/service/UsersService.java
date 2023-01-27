package com.security.service;

import java.util.List;

import com.security.entity.Users;

public interface UsersService {
	public List<Users> getAllUsers();

	public Users getById(int id) throws Exception;

	public Users postData(Users users);

	public Users putdata(int id, Users user);

	public void DeleteById(int id);

}
