package com.rd.controller;

import com.rd.model.User;
import com.rd.repository.UserRepository;
import com.rd.util.MessageHandler;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/secure")
public class SecureController extends MessageHandler{

    public Map<String, Object>map;
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Secure Hello!";
    }

    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user){
        map = new HashMap<>();
        try {
            if (user != null ){
                userRepository.createUser(user);
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return responMessage(user, HttpStatus.OK);
    }

}
