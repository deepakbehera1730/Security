package com.security.userimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.UserEntity;
import com.security.repository.Usersrepo;

@Service
public class UserImpl implements UserDetailsService {

	@Autowired
	private Usersrepo usersrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity users=usersrepo.findByUsername(username);
		if(users==null)
		{
			 throw new UsernameNotFoundException("not found 404");
			 
		}
		return new PricipalUser(users);
		
	}

}
