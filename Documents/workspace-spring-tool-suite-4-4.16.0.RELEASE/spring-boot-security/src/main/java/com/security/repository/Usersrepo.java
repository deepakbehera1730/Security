package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.UserEntity;

@Repository
public interface Usersrepo extends JpaRepository<UserEntity, Integer>{

	UserEntity findByUsername(String username);
}
