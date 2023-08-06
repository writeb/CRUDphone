package com.example.demo.mapper;

import com.example.demo.modelFirst.User;
import com.example.demo.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);
    User toModel(UserDTO userDTO);
    List<UserDTO> toDtoList(List<User> userList);
    List<User>  toModelList(List<UserDTO> userDTOList);
}
