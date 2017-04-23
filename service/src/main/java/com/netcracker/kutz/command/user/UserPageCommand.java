package com.netcracker.kutz.command.user;

import com.netcracker.kutz.dao.AccountMySQLDAO;
import com.netcracker.kutz.entity.Account;
import com.netcracker.kutz.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 21.04.17.
 */
public class UserPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        AccountMySQLDAO accountMySQLDAO = new AccountMySQLDAO();

        List<Account> accountList = accountMySQLDAO.getAll();

        List<String[]> mainTable = new LinkedList<String[]>();
        for (Account account : accountList) {
            System.out.println(account.getUser_id());
            if(Integer.parseInt(String.valueOf(request.getSession().getAttribute("USER_ID")))==account.getUser_id()){
                mainTable.add(new String[]{String.valueOf(account.getId()),
                        accountMySQLDAO.getCardNumberByID(account.getId()),
                        String.valueOf(account.getSum()),
                        String.valueOf(account.getBlockStatus())});
            }
        }
        request.setAttribute("mainTable",mainTable);
            return  "/view/userPage.jsp";
    }
}
