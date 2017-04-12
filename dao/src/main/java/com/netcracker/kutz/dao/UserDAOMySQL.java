package com.netcracker.kutz.dao;

import com.netcracker.kutz.daoUtil.Connector;
import com.netcracker.kutz.entity.User;
import com.netcracker.kutz.enums.UserType;
import com.netcracker.kutz.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 08.04.17.
 */
public class UserDAOMySQL implements UserDAO {

    private final String SQL_ADD_USER = "INSERT INTO `payments`.`users` (`role_id`, `login`, `password`, `name`, `surname`) VALUES (?, ?, ?, ?, ?);";
    private final String SQL_UPDATE_USER = "UPDATE `payments`.`users` SET `role_id`=?, `login`=?, `password`=?, `name`=?, `surname`=? WHERE `user_id`=?;";
    private final String SQL_DELETE_USER = "DELETE FROM `payments`.`users` WHERE `user_id`=?;";
    private final String SQL_GET_ALL_USER = "SELECT * FROM `payments`.`users`";
    private final String SQL_GET_BY_ID_USER = "SELECT * FROM payments.users WHERE user_id = ?;";

    public void add(User user) throws DAOException, SQLException {
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = cn.prepareStatement(SQL_ADD_USER);
        if (user.getUserType() == UserType.ADMINISTRATOR) {
            st.setInt(1, 1);
        } else {
            st.setInt(1, 0);
        }
        st.setString(2, user.getLogin());
        st.setString(3, user.getPassword());
        st.setString(4, user.getName());
        st.setString(5, user.getSurname());
        st.executeUpdate();
        st.close();
        cn.close();
    }

    public boolean update(User user) throws DAOException {
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_UPDATE_USER);
            if (user.getUserType() == UserType.ADMINISTRATOR) {
                st.setInt(1, 1);
            } else {
                st.setInt(1, 0);
            }
            st.setString(2, user.getLogin());
            st.setString(3, user.getPassword());
            st.setString(4, user.getName());
            st.setString(5, user.getSurname());
            st.setInt(6, user.getId());
            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean delete(int id) throws DAOException {
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_DELETE_USER);
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> getAll() throws DAOException {
        List<User> result = new LinkedList<User>();
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_ALL_USER);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                UserType userType;
                if (rs.getInt(2) == 0) {
                    userType = UserType.USER;
                } else {
                    userType = UserType.ADMINISTRATOR;
                }
                result.add(new User(rs.getInt(1), userType, rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public User getByID(int id) throws DAOException {
        User result = new User();
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_BY_ID_USER);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                UserType userType;
                if (rs.getInt(2) == 0) {
                    userType = UserType.USER;
                } else {
                    userType = UserType.ADMINISTRATOR;
                }
                result = (new User(rs.getInt(1), userType, rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6)));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
