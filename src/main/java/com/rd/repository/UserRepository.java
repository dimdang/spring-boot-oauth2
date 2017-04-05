package com.rd.repository;

import com.rd.model.User;

/**
 * Created by Chheng on 3/3/2017.
 */
public interface UserRepository {

   User findByEmail(String email);
}
