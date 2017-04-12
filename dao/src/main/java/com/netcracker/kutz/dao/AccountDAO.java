package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.Account;
import com.netcracker.kutz.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public interface AccountDAO {
    void add(Account account) throws DAOException, SQLException;
    List<Account> getAll() throws DAOException;
    Account getByID(int id) throws DAOException;
    boolean delete(int id) throws DAOException;
}
