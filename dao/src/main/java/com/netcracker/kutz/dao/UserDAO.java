package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Егор on 08.04.17.
 */
public interface UserDAO{
    void add(User user) throws SQLException;
    boolean update(User user) throws SQLException;
    List<User> getAll();
    User getByID(int id);
    boolean delete(int id);
}
