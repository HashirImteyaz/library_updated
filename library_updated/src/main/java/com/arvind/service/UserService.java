package com.arvind.service;
import java.util.List;

import com.arvind.entity.*;
public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email,String password);
	public List<User> getAllUser();
}
