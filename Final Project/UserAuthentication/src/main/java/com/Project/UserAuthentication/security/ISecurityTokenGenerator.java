package com.Project.UserAuthentication.security;

import com.Project.UserAuthentication.domain.UserAuthentication;

import java.util.Map;

public interface ISecurityTokenGenerator {

    Map<String,String> createToken(UserAuthentication userAuthentication);
}
