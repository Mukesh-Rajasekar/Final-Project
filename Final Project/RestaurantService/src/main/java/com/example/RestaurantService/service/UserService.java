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
    public User updateUser(String userId, User updatedUser) {
        // Retrieve the user by userId
        Optional<User> optionalUser = iUserRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null; // Return null if the user is not found
        }

        User user = optionalUser.get();

        // Update the username and email if they are provided
        if (updatedUser.getUsername() != null && !updatedUser.getUsername().equals(user.getUsername())) {
            if (iUserRepository.findByUsername(updatedUser.getUsername()) != null) {
                return null; // Return null if the username is already taken
            }
            user.setUsername(updatedUser.getUsername());
        }

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().equals(user.getEmail())) {
            if (iUserRepository.findByEmail(updatedUser.getEmail()) != null) {
                return null; // Return null if the email is already in use
            }
            user.setEmail(updatedUser.getEmail());
        }

        return iUserRepository.save(user);
    }
}
