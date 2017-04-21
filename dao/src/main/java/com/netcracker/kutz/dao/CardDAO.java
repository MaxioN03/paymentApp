package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.Card;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public interface CardDAO {
    void add(Card card) throws  SQLException;
    List<Card> getAll();
    Card getByID(int id);
    boolean delete(int id);
}
