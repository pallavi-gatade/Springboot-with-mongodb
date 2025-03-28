package com.practice.service.impl;

import org.springframework.stereotype.Service;

import com.practice.dto.UserRequestDto;
import com.practice.entity.User;
import com.practice.repository.UserRepository;
import com.practice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserRequestDto saveUser(UserRequestDto userData) {

		if (userData == null) {
			throw new IllegalArgumentException("User data cannot be null");
		}

		User user = new User();
		user.setName(userData.getUserName());
		user.setTier(userData.getTierType());
		userRepo.save(user);

		return userData;
	}

}
