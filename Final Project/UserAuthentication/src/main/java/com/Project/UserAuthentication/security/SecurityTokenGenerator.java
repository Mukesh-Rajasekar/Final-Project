package com.Project.UserAuthentication.security;

import com.Project.UserAuthentication.domain.UserAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGenerator implements ISecurityTokenGenerator{


    @Override
    public Map<String, String> createToken(UserAuthentication userAuthentication) {
        Map<String, Object> userdata= new HashMap<>();
    userdata.put("userId",userAuthentication.getUserId());
    userdata.put("password",userAuthentication.getPassword());
        System.out.println("UserData: "+userdata);
  String JWTtoken;
  JWTtoken= Jwts.builder()
          .setClaims(userdata)
          .setIssuedAt(new Date())
          .signWith(SignatureAlgorithm.HS256,"mySecretkey")
          .compact();
        System.out.println(JWTtoken);

    Map<String,String> map = new HashMap<>();
    map.put("token",JWTtoken);
    map.put("message","Login Successful");
        System.out.println(map);
    return map;
    }
}
