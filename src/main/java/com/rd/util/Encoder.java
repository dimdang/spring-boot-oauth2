package com.rd.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Chheng on 3/4/2017.
 */
public class Encoder{

    /*public static void main(String[]args){
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
