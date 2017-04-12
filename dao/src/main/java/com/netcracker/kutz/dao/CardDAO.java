package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.Card;
import com.netcracker.kutz.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public interface CardDAO {
    void add(Card card) throws DAOException, SQLException;
    List<Card> getAll() throws DAOException;
    Card getByID(int id) throws DAOException;
    boolean delete(int id) throws DAOException;
}
