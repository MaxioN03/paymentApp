package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public interface AccountDAO {
    void add(Account account) throws SQLException;
    List<Account> getAll();
    Account getByID(int id);
    boolean delete(int id);
}
