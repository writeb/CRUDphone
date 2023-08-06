package com.example.demo.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<UserDTO> getUsers(){
        return adminService.getUsers();
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return adminService.addUser(userDTO);
    }

    @GetMapping(value = "{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id){
        return adminService.getUserById(id);
    }

    @PutMapping(value = "{id}")
    public UserDTO updateUser(@PathVariable(name = "id") Long id, @RequestBody UserDTO userDTO){
        return adminService.updateUser(id, userDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable(name = "id") Long id){
        adminService.deleteUser(id);
    }

    @GetMapping(value = "{limit}/{offset}")
    public Page<UserDTO> getUsersByLimitOffset(@PathVariable(name = "limit") int limit,
                                              @PathVariable(name = "offset") int offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return adminService.getUsersByLimitOffset(pageable);
    }
}
