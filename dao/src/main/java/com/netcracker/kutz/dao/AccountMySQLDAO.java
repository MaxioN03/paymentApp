package com.netcracker.kutz.dao;

import com.netcracker.kutz.entity.Account;
import com.netcracker.kutz.enums.BlockStatus;
import com.netcracker.kutz.util.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.netcracker.kutz.enums.BlockStatus.BLOCKED;
import static com.netcracker.kutz.enums.BlockStatus.UNLOCKED;

/**
 * Created by Егор on 10.04.17.
 */
public class AccountMySQLDAO implements AccountDAO {
    private final String SQL_UPDATE_AMOUNT = "UPDATE `payments`.`account` SET `sum`=? WHERE  `acc_id`=?;";
    private final String SQL_ADD_ACCOUNT = "INSERT INTO `payments`.`account` (`card_id`, `user_id`, `sum`, `block_status`) VALUES (?, ?, ?, ?);";
    private final String SQL_GET_ALL_ACCOUNT = "SELECT * FROM payments.account LIMIT 0, 1000;";
    private final String SQL_GET_BY_ID_ACCOUNT = "SELECT * FROM payments.account where acc_id=?;";
    private final String SQL_DELETE_ACCOUNT = "DELETE FROM payments.account where acc_id=?;";
    private final String SQL_GET_CARD_NUMBER_BY_ID = "SELECT number FROM payments.card where payments.card.card_id=?;";
    private final String SQL_GET_USER_LOGIN_BY_ID = "SELECT login FROM payments.users where payments.users.user_id=?;";
    private final String SQL_CHANGE_BLOCKSTATUS = "UPDATE `payments`.`account` SET `block_status`=? WHERE  `acc_id`=?;";



    public void add(Account account){
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_ADD_ACCOUNT);
            st.setInt(1, account.getCard_id());
            st.setInt(2, account.getUser_id());
            st.setInt(3, account.getSum());
            if (account.getBlockStatus() == BlockStatus.BLOCKED) {
                st.setInt(4, 1);
            } else {
                st.setInt(4, 0);
            }
            st.executeUpdate();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Account> getAll(){
        List<Account> result = new LinkedList<Account>();
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_ALL_ACCOUNT);
            ResultSet rs = st.executeQuery();
            BlockStatus blockStatus;
            while (rs.next()) {
                if (rs.getInt(5) == 0) {
                    blockStatus = UNLOCKED;
                } else {
                    blockStatus = BLOCKED;
                }
                result.add(new Account(rs.getInt(1), rs.getInt(3), rs.getInt(2),
                        rs.getInt(4), blockStatus));
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

    public Account getByID(int id){

        Account result = new Account();
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_BY_ID_ACCOUNT);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            BlockStatus blockStatus;

            if (rs.next()) {
                if (rs.getInt(5) == 0) {
                    blockStatus = UNLOCKED;
                } else {
                    blockStatus = BLOCKED;
                }
                result = (new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), blockStatus));
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

    public boolean delete(int id){
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_DELETE_ACCOUNT);
            st.setInt(1,id);
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

    public String getCardNumberByID(int id){
        String result = null;
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_CARD_NUMBER_BY_ID);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            BlockStatus blockStatus;
            if (rs.next()) {
                result = rs.getString(1);
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

    public String getUserLoginByID(int id){
        String result = null;
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_USER_LOGIN_BY_ID);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            BlockStatus blockStatus;
            if (rs.next()) {
                result = rs.getString(1);
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

    public void changeBlokStatus(int status, int accID){
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_CHANGE_BLOCKSTATUS);
            st.setInt(1,status);
            st.setInt(2,accID);
            st.executeUpdate();
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
    }

    public boolean updateAmount(Account account){
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_UPDATE_AMOUNT);
            st.setInt(1, account.getSum());
            st.setInt(2, account.getId());
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
}
