package com.rd.services;

import com.rd.model.Product;
import com.rd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dang Dim
 * Date     : 11-Aug-17, 2:53 PM
 * Email    : d.dim@gl-f.com
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    public Product findById(int id){
        return productRepository.findOne(id);
    }


}
