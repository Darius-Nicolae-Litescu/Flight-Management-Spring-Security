package com.controller.admin;

import com.configuration.MockUserRepository;
import com.configuration.model.CustomUser;
import com.wrapper.ListWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/abcflights")
public class UserManagementController {
    @GetMapping("/users")
    public ResponseEntity<ListWrapper<List<CustomUser>>> getAllUsers(){
        List<CustomUser> customUserList = MockUserRepository.userRepository.getAll();
        return new ResponseEntity<>(new ListWrapper<>((long) customUserList.size(), customUserList), HttpStatus.OK);
    }

}