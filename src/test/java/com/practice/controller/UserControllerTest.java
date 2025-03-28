package com.practice.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mongodb.assertions.Assertions;
import com.practice.dto.UserRequestDto;
import com.practice.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Test
	public void testSaveUser() throws Exception {

		UserRequestDto requestDto = new UserRequestDto();
		requestDto.setUserName("Sachin");
		requestDto.setTierType(1);

		 when(userService.saveUser(requestDto)).thenReturn(requestDto);

		ResponseEntity<UserRequestDto> userRequestDto = userController.saveUser(requestDto);

		Assertions.assertNotNull(userRequestDto);
	}
}
