package com.netcracker.kutz;

import com.netcracker.kutz.dao.UserMySQLDAO;

/**
 * Created by Егор on 18.04.17.
 */
public class TEST {
    public static void main(String[] args) {
        UserMySQLDAO userMySQLDAO = new UserMySQLDAO();
        System.out.println(userMySQLDAO.getAll());
    }
}
