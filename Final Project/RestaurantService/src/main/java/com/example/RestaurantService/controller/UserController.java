package com.example.RestaurantService.controller;

import com.example.RestaurantService.domain.User;
import com.example.RestaurantService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api/v1")
public class UserController {

    private IUserService iUserService;
    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = iUserService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUsernameAndEmail/{userId}")
    public ResponseEntity<User> updateUsernameAndEmail(@PathVariable String userId,
                                                       @RequestBody User updatedUser) {
        User result = iUserService.updateUser(userId, updatedUser);
        if (result == null) {
            return ResponseEntity.badRequest().body(null); // Return 400 if update fails
        }
        return ResponseEntity.ok(result); // Return 200 OK with updated user
    }

}
