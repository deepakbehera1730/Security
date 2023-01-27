package com.security.serviceImpl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.Users;

public class PrincipalUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users users;

	public PrincipalUser(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

//		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
//		set.add(new SimpleGrantedAuthority(this.users.getRole()));
//
//		return set;

//		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.users.getRole());
//		return List.of(authority);

		return Collections.singleton(new SimpleGrantedAuthority(this.users.getRole()));

	}

	@Override
	public String getPassword() {

		return this.users.getPassword();
	}

	@Override
	public String getUsername() {

		return this.users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
