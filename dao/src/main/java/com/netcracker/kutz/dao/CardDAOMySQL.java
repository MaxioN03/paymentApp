package com.netcracker.kutz.dao;

import com.netcracker.kutz.daoUtil.Connector;
import com.netcracker.kutz.entity.Card;
import com.netcracker.kutz.exception.DAOException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public class CardDAOMySQL implements  CardDAO {

    private final String SQL_ADD_CARD = "INSERT INTO `payments`.`card` (`number`, `valid_thru`) VALUES (?, ?);";
    private final String SQL_GET_ALL_CARD = "SELECT * FROM payments.card;";
    private final String SQL_GET_BY_ID_CARD = "SELECT * FROM payments.card where card_id=?;";
    private final String SQL_DELETE_CARD = "DELETE FROM `payments`.`card` WHERE `card_id`=?;";

    public void add(Card card) throws DAOException, SQLException {
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = cn.prepareStatement(SQL_ADD_CARD);
        st.setString(1, card.getNumber());
        st.setString(2, card.getValidThru());
        st.executeUpdate();
        st.close();
        cn.close();
    }

    public List<Card> getAll() throws DAOException {
        List<Card> result = new LinkedList<Card>();
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_ALL_CARD);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                result.add(new Card(rs.getInt(1),rs.getString(2),rs.getString(3)));
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

    public Card getByID(int id) throws DAOException {
        Card result = new Card();
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_GET_BY_ID_CARD);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                result = (new Card(rs.getInt(1),rs.getString(2),rs.getString(3)));
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

    public boolean delete(int id) throws DAOException {
        Connector cnr = new Connector();
        Connection cn = cnr.getConnection();
        PreparedStatement st = null;
        try {
            st = cn.prepareStatement(SQL_DELETE_CARD);
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
}
