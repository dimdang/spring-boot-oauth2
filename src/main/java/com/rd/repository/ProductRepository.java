package com.rd.repository;

import com.rd.model.Product;
import com.rd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chheng on 3/3/2017.
 */

public interface ProductRepository extends JpaRepository<Product, Integer>{

    /*
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    */
}
