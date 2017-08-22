package com.rd.repository.impl;

import com.rd.model.Product;
import com.rd.model.User;
import com.rd.repository.ProductRepository;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chheng on 3/3/2017.
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

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
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean updateProduct(Product product) {

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean deleteProduct(Product product) {

        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("id", product.getId()));
            transaction = session.beginTransaction();
            session.delete( criteria.list().get(0));
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Product> finProductById(int id) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("id", id));
            return criteria.list();
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
