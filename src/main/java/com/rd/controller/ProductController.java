package com.rd.controller;

import com.rd.model.Product;
import com.rd.repository.ProductRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findProductById(@PathVariable("id") int id) {
        return productRepository.finProductById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addProduct(@RequestBody Product product){
        Map<String, Object> map = new HashMap<>();
        try {
            if (product != null && productRepository.addProduct(product)){
                map.put("STATUS", true);
                map.put("MESSAGE", "PRODUCT CREATED...!");
            }else {
                map.put("STATUS", false);
                map.put("MESSAGE", "Internal server error ........... cal bucky for help!");
            }

        }catch (HibernateException e){
            e.printStackTrace();
        }

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK );
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateProduct(@RequestBody Product product){
        Map<String, Object> map = new HashMap<>();
        try {
            if (product != null && productRepository.updateProduct(product)){
                map.put("STATUS", true);
                map.put("MESSAGE", "PRODUCT UPDATED..........!");
            }else {
                map.put("STATUS", false);
                map.put("MESSAGE", "Internal server error ........... cal bucky for help!");
            }

        }catch (HibernateException e){
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK );
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteProduct(@RequestBody Product product){
        Map<String, Object> map = new HashMap<>();
        try {
            if (product != null && productRepository.deleteProduct(product)){
                map.put("STATUS", true);
                map.put("MESSAGE", "PRODUCT HAVE BEEN DELETED..........!");
            }else {
                map.put("STATUS", false);
                map.put("MESSAGE", "Internal server error ........... cal bucky for help!");
            }

        }catch (HibernateException e){
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK );
    }

}
