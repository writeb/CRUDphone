package com.example.demo;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modelFirst.User;
import com.example.demo.repositoryFirst.UserRepository;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@SpringBootTest
class TestApp {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	void checkUserDTO(){
		User user = new User();
		user.setId(12L);
		user.setEmail("naruto@gmail.com");
		user.setFullName("Naruto Uzumaki");
		user.setPassword("qweqwe");
		user.setBirthYear(LocalDate.parse("2004-04-14"));
		user.setFirstPhone("87762413701");
		user.setSecondPhone("87762413701");
		user.setCreatedAt(Timestamp.from(Instant.now()));

		UserDTO userDTO = userMapper.toDto(user);

		Assertions.assertEquals(user.getId(), userDTO.getId());
		Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
		Assertions.assertEquals(user.getFullName(), userDTO.getFullName());
		Assertions.assertEquals(user.getPassword(), userDTO.getPassword());
		Assertions.assertEquals(user.getBirthYear(), userDTO.getBirthYear());
		Assertions.assertEquals(user.getFirstPhone(), userDTO.getFirstPhone());
		Assertions.assertEquals(user.getSecondPhone(), userDTO.getSecondPhone());
		Assertions.assertEquals(user.getCreatedAt(), userDTO.getCreatedAt());

	}

	@Test
	void checkInsertIntoDB(){

		userRepository.deleteAll();

		User user = new User();
		user.setEmail("naruto@gmail.com");
		user.setFullName("Naruto Uzumaki");
		user.setPassword("qweqwe");
		user.setBirthYear(LocalDate.parse("2004-04-14"));
		user.setFirstPhone("87762413701");
		user.setSecondPhone("87762413701");
		user.setCreatedAt(Timestamp.from(Instant.now()));

		UserDTO newUserDTO = adminService.addUser(userMapper.toDto(user));

		Assertions.assertNotNull(newUserDTO);
		Assertions.assertNotNull(newUserDTO.getId());
		Assertions.assertEquals(user.getEmail(), newUserDTO.getEmail());
		Assertions.assertEquals(user.getFullName(), newUserDTO.getFullName());
		Assertions.assertEquals(user.getPassword(), newUserDTO.getPassword());
		Assertions.assertEquals(user.getBirthYear(), newUserDTO.getBirthYear());
		Assertions.assertEquals(user.getFirstPhone(), newUserDTO.getFirstPhone());
		Assertions.assertEquals(user.getSecondPhone(), newUserDTO.getSecondPhone());
		Assertions.assertEquals(user.getCreatedAt(), newUserDTO.getCreatedAt());

		userRepository.deleteAll();

	}

}
