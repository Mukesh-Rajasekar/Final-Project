package com.Project.UserAuthentication.service;

import com.Project.UserAuthentication.domain.UserAuthentication;
import com.Project.UserAuthentication.exception.InvalidCredentialsException;
import com.Project.UserAuthentication.exception.UserAlreadyExistsException;
import com.Project.UserAuthentication.repository.IUserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthenticationService implements IUserAuthenticationService{

    private IUserAuthenticationRepository iUserAuthenticationRepository;

    @Autowired
    public UserAuthenticationService(IUserAuthenticationRepository iUserAuthenticationRepository) {
        this.iUserAuthenticationRepository = iUserAuthenticationRepository;
    }

    @Override
    public UserAuthentication registerUser(UserAuthentication userAuthentication) throws UserAlreadyExistsException {
        System.out.println("Inside Service Layer");
        Optional<UserAuthentication> optionalUser = iUserAuthenticationRepository.findById(userAuthentication.getUserId());
        System.out.println("Optional User: "+optionalUser);
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistsException();
        }

        return iUserAuthenticationRepository.save(userAuthentication);
    }

    @Override
    public UserAuthentication login(String userId, String password) throws InvalidCredentialsException {
        UserAuthentication user = iUserAuthenticationRepository.findByUserIdAndPassword(userId,password);
        if(user == null){ throw new InvalidCredentialsException();
        }


        return user;
    }
}
