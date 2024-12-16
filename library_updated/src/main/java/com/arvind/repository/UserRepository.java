package com.arvind.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.arvind.entity.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}