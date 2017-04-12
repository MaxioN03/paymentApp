package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.User;
import com.netcracker.kutz.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Егор on 08.04.17.
 */
public interface UserDAO{
    void add(User user) throws DAOException, SQLException;
    boolean update(User user) throws DAOException, SQLException;
    List<User> getAll() throws DAOException;
    User getByID(int id) throws DAOException;
    boolean delete(int id) throws DAOException;
}
