package com.netcracker.kutz.daoUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Егор on 08.04.17.
 */
public class Connector {

    public Connection getConnection(){
        FileInputStream fis;
        Properties property = new Properties();
        Connection cn = null;

        try {
            fis = new FileInputStream("dao\\src\\main\\resources\\db_prop.properties");

            property.load(fis);

            String host = property.getProperty("SQL_DB_URL");
            String login = property.getProperty("SQL_DB_USERNAME");
            String password = property.getProperty("SQL_DB_PASSWORD");

             cn = DriverManager.getConnection(host,login,password);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }
}
