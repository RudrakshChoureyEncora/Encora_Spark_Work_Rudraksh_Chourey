package com.UnitTestingMockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.UnitTestingMockito.controller.UserController;
import com.UnitTestingMockito.model.Users;
import com.UnitTestingMockito.repository.UserRepo;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepo userRepository;
	
	@Test
	void shouldReturnUser_whenExists() throws Exception {
		when(userRepository.findById(1L)).thenReturn(Optional.of(new Users(1L,"Alice")));
		mockMvc.perform(get("/users/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Alice"));
		
	}
}
