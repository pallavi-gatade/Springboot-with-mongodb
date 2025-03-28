package com.practice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.dto.UserRequestDto;
import com.practice.entity.User;
import com.practice.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepo;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Test
	public void testSaveUser() {
		UserRequestDto userDto = new UserRequestDto();
		userDto.setUserName("Sandhya Jagtap");
		userDto.setTierType(1);
		
		User user = new User();
		user.setName(userDto.getUserName());
		user.setTier(userDto.getTierType());
		
		UserRequestDto result = userServiceImpl.saveUser(userDto);

		Assertions.assertNotNull(result);
		Assertions.assertEquals("Sandhya Jagtap", result.getUserName());
		assertEquals(1, result.getTierType());

		verify(userRepo, times(1)).save(any(User.class));
	}

	@Test
	public void testSaveUser_NullUser_ShouldThrowException() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			userServiceImpl.saveUser(null);
		});

		assertEquals("User data cannot be null", exception.getMessage());

		verify(userRepo, never()).save(any(User.class));

	}

}
