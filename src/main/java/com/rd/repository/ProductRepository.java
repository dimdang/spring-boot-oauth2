package com.rd.repository;

import com.rd.model.Product;
import com.rd.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chheng on 3/3/2017.
 */

public interface ProductRepository {

    List<Product> getAllProducts();
}
