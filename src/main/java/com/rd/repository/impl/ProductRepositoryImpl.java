package com.rd.repository.impl;

import com.rd.model.Product;
import com.rd.model.User;
import com.rd.repository.ProductRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chheng on 3/3/2017.
 */
@Repository
@Transactional
public class ProductRepositoryImpl /*implements ProductRepository */{
/*

    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;
    Transaction transaction = null;

    @Override
    public List<Product> getAllProducts() {

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Product.class);
            return criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            if (session != null)
                session.close();
        }

    }

    @Override
    public boolean addProduct(Product product) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            if (session != null){
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

*/

}
