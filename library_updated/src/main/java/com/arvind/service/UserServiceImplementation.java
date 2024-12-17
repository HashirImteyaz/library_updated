package com.arvind.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.arvind.entity.User;
import com.arvind.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
	private final UserRepository userRepository;

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub

		User validUser = userRepository.findByEmail(email);
		if (validUser != null && validUser.getPassword().equals(password)) {
			return validUser;
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
