package com.qsys.users.controller;


import com.qsys.users.entity.Users;
import com.qsys.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Users>> listAllUsers() {
        List<Users> userList = usersService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public Users getUserByEmail(@PathVariable String email) {
        return usersService.getUserByEmail(email);
    }

    @PostMapping("/saveUser")
    public Users saveUser(@RequestBody Users user) {
        return usersService.saveUser(user);
    }

    @PutMapping("/updateUser")
    public Users updateUser(@RequestBody Users user) {
        return usersService.updateUser(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        usersService.deleteUserById(id);
    }

}
