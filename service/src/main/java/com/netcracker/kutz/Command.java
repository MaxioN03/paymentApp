package com.netcracker.kutz;

import com.netcracker.kutz.dao.AccountMySQLDAO;
import com.netcracker.kutz.dao.CardMySQLDAO;
import com.netcracker.kutz.dao.UserMySQLDAO;
import com.netcracker.kutz.entity.Account;
import com.netcracker.kutz.entity.Card;
import com.netcracker.kutz.entity.User;
import com.netcracker.kutz.entity.Util;
import com.netcracker.kutz.enums.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 18.04.17.
 */
public class Command {

    public static String handle(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        String page = "html/userPage.jsp";
        String buttonAttribute = (String) request.getParameter("button");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        switch (buttonAttribute) {
            case "Enter":
                return handleAuth(request, response);
            case "Block":
                return blockAccount(Integer.parseInt(request.getParameter("accNumberBlock")), request, response);
            case "Transfer":
                return transfer(request, response);
        }

        return page;
    }

    private static String transfer(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("accNumber") == "" || request.getParameter("recAccNumber") == "" ||
                request.getParameter("amount") == "" ||
                request.getParameter("validThru1") == "" ||
                request.getParameter("validThru2") == ""
                ) {

            request.setAttribute("error", "Wrong data!");
        } else {
            AccountMySQLDAO accountMySQLDAO = new AccountMySQLDAO();
            CardMySQLDAO cardMySQLDAO = new CardMySQLDAO();

            Account sender = accountMySQLDAO.getByID(Integer.parseInt(request.getParameter("accNumber")));
            Card senderCard = cardMySQLDAO.getByID(sender.getCard_id());
            Account recipient = accountMySQLDAO.getByID(Integer.parseInt(request.getParameter("recAccNumber")));

            String[] validThru = Util.parseValidThru(senderCard.getValidThru());
            int summ = Integer.parseInt(request.getParameter("amount"));

            if(validThru[0].equals(request.getParameter("validThru1")) &&
                    validThru[1].equals(request.getParameter("validThru2")) &&
                    recipient!=null &&
                    sender.getSum()>summ){
                sender.setSum(sender.getSum()-summ);
                recipient.setSum(recipient.getSum()+summ);
                accountMySQLDAO.updateAmount(sender);
                accountMySQLDAO.updateAmount(recipient);
            }
            else {
                request.setAttribute("error", "Wrong data!");
            }
        }
        return handleUserPage(request, response);
    }

    private static String handleAuth(HttpServletRequest request,
                                     HttpServletResponse response) {

        String page = "html/index.jsp";
        UserMySQLDAO userMySQLDAO = new UserMySQLDAO();

        List<User> userList = userMySQLDAO.getAll();
        for (User user : userList) {
            if (user.getLogin().equals(request.getParameter("login")) &&
                    user.getPassword().equals(request.getParameter("password"))) {

                HttpSession session = request.getSession(true);
                String userType;
                if (userMySQLDAO.getByLogin(request.getParameter("login")).getUserType() == UserType.ADMINISTRATOR) {
                    userType = "ADMIN";
                } else {
                    userType = "USER";
                }
                session.setAttribute("ROLE", userType);
                session.setAttribute("USER_ID", user.getId());
                page = handleUserPage(request, response);
                return page;
            }
        }
        request.setAttribute("error", "Wrong login or password!");
        return page;
    }

    private static String handleUserPage(HttpServletRequest request,
                                         HttpServletResponse response) {
        AccountMySQLDAO accountMySQLDAO = new AccountMySQLDAO();
        CardMySQLDAO cardMySQLDAO = new CardMySQLDAO();

        List<Account> accountList = accountMySQLDAO.getAll();

        List<String[]> mainTable = new LinkedList<String[]>();
        for (Account account : accountList) {
            mainTable.add(new String[]{String.valueOf(account.getId()),
                    accountMySQLDAO.getCardNumberByID(account.getId()),
                    String.valueOf(account.getSum()),
                    String.valueOf(account.getBlockStatus())});
        }

        request.setAttribute("mainTable", mainTable);
        return "html/userPage.jsp";
    }

    public static String blockAccount(int accId, HttpServletRequest request,
                                      HttpServletResponse response) {
        String role = (String) request.getSession().getAttribute("ROLE");
        AccountMySQLDAO accountMySQLDAO = new AccountMySQLDAO();

        Account account = accountMySQLDAO.getByID(accId);

        if (role.equals("ADMIN")) {
            accountMySQLDAO.changeBlokStatus(0, account.getId());
        } else {
            accountMySQLDAO.changeBlokStatus(1, account.getId());
        }
        return handleUserPage(request, response);
    }
}
