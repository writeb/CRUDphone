package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modelFirst.User;
import com.example.demo.repositoryFirst.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public UserDTO addUser(UserDTO user){
        if (userRepository.findByEmail(user.getEmail()) == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            // you need to comment passwordEncoder for password for test,
            // because it generates encoded password permanently
            // also same to createdAt property
            user.setCreatedAt(Timestamp.from(Instant.now()));
            return userMapper.toDto(userRepository.save(userMapper.toModel(user)));
        }
        return null;
    }
    public List<UserDTO> getUsers(){
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDTO getUserById(Long id){
        return userMapper.toDto(userRepository.findUserById(id));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO){
        UserDTO oldUserDTO = userMapper.toDto(userRepository.findById(id).orElse(null));
        if (oldUserDTO!=null){
            oldUserDTO.setEmail(userDTO.getEmail());
            oldUserDTO.setFullName(userDTO.getFullName());
            oldUserDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            oldUserDTO.setBirthYear(userDTO.getBirthYear());
            oldUserDTO.setFirstPhone(userDTO.getFirstPhone());
            oldUserDTO.setSecondPhone(userDTO.getSecondPhone());
            oldUserDTO.setCreatedAt(oldUserDTO.getCreatedAt());
            return userMapper.toDto(userRepository.save(userMapper.toModel(oldUserDTO)));
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public Page<UserDTO> getUsersByLimitOffset(Pageable pageable){
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toDto);
    }
}
