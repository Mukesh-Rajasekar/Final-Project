package com.example.RestaurantService.service;

import com.example.RestaurantService.domain.User;
import com.example.RestaurantService.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
