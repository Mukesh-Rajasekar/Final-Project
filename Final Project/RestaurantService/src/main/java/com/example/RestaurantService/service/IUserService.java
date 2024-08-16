package com.example.RestaurantService.service;

import com.example.RestaurantService.domain.User;

import java.util.Optional;

public interface IUserService {

    User registerUser(User user);
    User updateUsernameAndEmail(String userId, String newUsername, String newEmail);

}
