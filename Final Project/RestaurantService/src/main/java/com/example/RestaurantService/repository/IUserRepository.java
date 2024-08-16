package com.example.RestaurantService.repository;

import com.example.RestaurantService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User,String> {



}
