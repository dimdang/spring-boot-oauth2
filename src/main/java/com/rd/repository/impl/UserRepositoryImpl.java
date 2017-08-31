package com.rd.repository.impl;

import com.rd.model.User;
import com.rd.repository.UserRepository;
import com.rd.util.Encoder;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

/**
 * Created by Chheng on 3/3/2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;
    Session sessions = null;
    Transaction transaction = null;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String username) {
        Session session = null;
        Transaction transaction = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (username != null && !username.equals("")) {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("username", username));
                user = (User) criteria.list().get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (transaction != null)
                transaction.commit();
        }

        return user;
    }

    @Override
    public boolean createUser(User user) {
        try {
            sessions = sessionFactory.openSession();
            transaction = sessions.beginTransaction();
            Criteria criteria = sessions.createCriteria(User.class);
            criteria.add(Restrictions.eq("username", user));
            if (user.getUsername().equals(criteria.list().get(0))){
                throw new EntityExistsException("User " + user.getUsername() + " was found in the database");
            }else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                sessions.persist(user);
                transaction.commit();
                return true;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {

            if (sessions != null) {
                sessions.close();
            }
        }
    }

}
