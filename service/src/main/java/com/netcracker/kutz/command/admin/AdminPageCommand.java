package com.netcracker.kutz.command.admin;

import com.netcracker.kutz.dao.AccountMySQLDAO;
import com.netcracker.kutz.entity.Account;
import com.netcracker.kutz.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 21.04.17.
 */
public class AdminPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        AccountMySQLDAO accountMySQLDAO = new AccountMySQLDAO();

        List<Account> accountList = accountMySQLDAO.getAll();
        List<String[]> mainTable = new LinkedList<String[]>();

        for (Account account : accountList) {
            mainTable.add(new String[]{String.valueOf(account.getId()),
                    String.valueOf(account.getCard_id()),
                    accountMySQLDAO.getCardNumberByID(account.getId()),
                    String.valueOf(account.getUser_id()),
                    accountMySQLDAO.getUserLoginByID(account.getUser_id()),
                    String.valueOf(account.getBlockStatus())});
        }
        request.setAttribute("mainTable",mainTable);
            return  "/view/adminPage.jsp";

    }
}
