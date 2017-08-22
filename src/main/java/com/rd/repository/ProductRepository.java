package com.rd.repository;

import com.rd.model.Product;

import java.util.List;

/**
 * Created by Chheng on 3/3/2017.
 */

public interface ProductRepository {

    public List<Product> getAllProducts();
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(Product product);
    public List<Product> finProductById(int id);
}
