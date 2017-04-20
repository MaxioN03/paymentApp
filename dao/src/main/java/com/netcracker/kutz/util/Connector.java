package com.netcracker.kutz.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            property.load(getClass().getClassLoader().getResourceAsStream("db_prop.properties"));

            //property.load(fis);
            Class.forName(property.getProperty("SQL_DB_DRIVER_CLASS"));
            String host = property.getProperty("SQL_DB_URL");
            String login = property.getProperty("SQL_DB_USERNAME");
            String password = property.getProperty("SQL_DB_PASSWORD");
            cn = DriverManager.getConnection(host,login,password);



        } catch (IOException|SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cn;
    }
}
