package com.Project.UserAuthentication.service;

import com.Project.UserAuthentication.domain.UserAuthentication;
import com.Project.UserAuthentication.exception.InvalidCredentialsException;
import com.Project.UserAuthentication.exception.UserAlreadyExistsException;

public interface IUserAuthenticationService {
    UserAuthentication registerUser(UserAuthentication userAuthentication) throws UserAlreadyExistsException;
    UserAuthentication login(String userId, String password) throws InvalidCredentialsException;
}
