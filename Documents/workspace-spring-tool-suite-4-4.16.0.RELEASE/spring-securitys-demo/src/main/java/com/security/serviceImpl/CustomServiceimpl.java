package com.security.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.Users;
import com.security.repo.UsersRepository;

@Service
public class CustomServiceimpl implements UserDetailsService {
	@Autowired
	private UsersRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users uses2 = this.repository.findByUsername(username);

		if (uses2 == null) {
			throw new UsernameNotFoundException("404 not found");
		}

		return new PrincipalUser(uses2);
	}

}
