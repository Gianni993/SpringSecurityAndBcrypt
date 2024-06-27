package com.luv2code.springboot.cruddemo.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Bcrypt {

    public String encodePsw(String theCleanPsw){

        String salt = BCrypt.gensalt(12);
        return "{bcrypt}" + BCrypt.hashpw(theCleanPsw, salt);

    }
}
