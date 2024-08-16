package com.example.RestaurantService.service;

import com.example.RestaurantService.domain.User;
import com.example.RestaurantService.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{


    private IUserRepository iUserRepository;

    @Autowired
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User registerUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User updateUsernameAndEmail(String userId, String newUsername, String newEmail) {
        // Retrieve the user by userId
        Optional<User> optionalUser = iUserRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null; // Return null if the user is not found
        }

        User user = optionalUser.get();

        // Check if the new username already exists and is not the current user's username
        if (!user.getUsername().equals(newUsername) && iUserRepository.findByUsername(newUsername) != null) {
            return null; // Return null if the username is already taken
        }

        // Check if the new email already exists and is not the current user's email
        if (!user.getEmail().equals(newEmail) && iUserRepository.findByEmail(newEmail) != null) {
            return null; // Return null if the email is already in use
        }

        // Update the username and email
        user.setUsername(newUsername);
        user.setEmail(newEmail);

        return iUserRepository.save(user);
    }

}
