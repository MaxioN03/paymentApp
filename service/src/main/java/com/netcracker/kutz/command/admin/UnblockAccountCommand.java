package com.netcracker.kutz.command.admin;

import com.netcracker.kutz.command.user.UserPageCommand;
import com.netcracker.kutz.constant.ParameterConstant;
import com.netcracker.kutz.dao.AccountMySQLDAO;
import com.netcracker.kutz.entity.Account;
import com.netcracker.kutz.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Егор on 22.04.17.
 */
public class UnblockAccountCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {   
        String page = null;
        AccountMySQLDAO accountMySQLDAO = new AccountMySQLDAO();

        Account account = accountMySQLDAO.getByID(Integer.parseInt(request.getParameter(ParameterConstant.accNumberBlockParameter)));
        accountMySQLDAO.changeBlokStatus(0, account.getId());

        if(request.getSession().getAttribute("ROLE").equals("ADMIN")){
            AdminPageCommand adminPageCommand = new AdminPageCommand();
            page =  adminPageCommand.execute(request);
        }
        else if(request.getSession().getAttribute("ROLE").equals("USER")){
            UserPageCommand userPageCommand = new UserPageCommand();
            page =  userPageCommand.execute(request);
        }
        return page;
    }
}
