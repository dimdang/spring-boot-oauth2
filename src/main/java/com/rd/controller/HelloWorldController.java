package com.rd.controller;

import com.rd.model.Product;
import com.rd.model.Role;
import com.rd.model.User;
import com.rd.repository.ProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class HelloWorldController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> test() {
        return productRepository.getAllProducts();
    }

}
