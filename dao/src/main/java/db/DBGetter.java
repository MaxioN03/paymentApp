package db;

import entities.Account;
import entities.Card;
import entities.user.User;
import entities.user.UserDTO;
import properties.PropertiesLoader;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 03.04.17.
 */
public class DBGetter {
    public static void main(String[] args) {
        DBGetter db = new DBGetter();
        System.out.println(db.getCard());
        System.out.println(db.getAccount());
    }

    private static PropertiesLoader prop = PropertiesLoader.getPropFromFile();
    private final String HOST = prop.getHost();
    private final String LOGIN = prop.getLogin();
    private final String PASSWORD = prop.getPassword();

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public List<User> getUserTotal() {
        List<User> result = new LinkedList<User>();
        String query = "SELECT * FROM users";
        try {
            con = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(new User(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<UserDTO> getUserDTO() {
        List<UserDTO> result = new LinkedList<UserDTO>();
        String query = "SELECT * FROM users";
        try {
            con = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(new UserDTO(rs.getInt(1),rs.getString(3),rs.getString(5),
                        rs.getString(6)));
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<Card> getCard(){
        List<Card> result = new LinkedList<Card>();
        String query = "SELECT * FROM card";
        try {
            con = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(new Card(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<Account> getAccount(){
        List<Account> result = new LinkedList<Account>();
        String query = "SELECT * FROM payment_system";
        try {
            con = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(new Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getInt(5),rs.getInt(4)));
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
