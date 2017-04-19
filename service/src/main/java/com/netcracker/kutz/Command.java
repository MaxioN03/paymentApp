package com.netcracker.kutz;

import com.netcracker.kutz.dao.UserMySQLDAO;
import com.netcracker.kutz.entity.User;
import com.netcracker.kutz.enums.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Егор on 18.04.17.
 */
public class Command {

    public static String handle(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        String page = "html/index.html";
        String buttonAttribute = (String) request.getParameter("button");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        switch (buttonAttribute) {
            case "Enter":
                return handleAuth(request, response);
        }

        return page;
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
                page="html/userPage.jsp";
                return page;
            }
        }
        request.setAttribute("error","error");
        return page;
    }
}
