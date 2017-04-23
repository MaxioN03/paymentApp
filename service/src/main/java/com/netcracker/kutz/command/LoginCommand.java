package com.netcracker.kutz.command;

import com.netcracker.kutz.command.admin.AdminPageCommand;
import com.netcracker.kutz.command.user.UserPageCommand;
import com.netcracker.kutz.constant.ErrorConstant;
import com.netcracker.kutz.constant.ParameterConstant;
import com.netcracker.kutz.implement.ActionCommand;
import com.netcracker.kutz.dao.UserMySQLDAO;
import com.netcracker.kutz.entity.User;
import com.netcracker.kutz.enums.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Егор on 21.04.17.
 */
public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/view/index.jsp";
        UserMySQLDAO userMySQLDAO = new UserMySQLDAO();

        List<User> userList = userMySQLDAO.getAll();
        for (User user : userList) {
            if (user.getLogin().equals(request.getParameter(ParameterConstant.loginParameter)) &&
                    user.getPassword().equals(request.getParameter(ParameterConstant.passwordParameter))) {

                HttpSession session = request.getSession(true);
                String userType;
                if (userMySQLDAO.getByLogin(request.getParameter(ParameterConstant.loginParameter)).getUserType() == UserType.ADMINISTRATOR) {
                    userType = "ADMIN";
                } else {
                    userType = "USER";
                }
                session.setAttribute("ROLE", userType);
                session.setAttribute("USER_ID", user.getId());
                if(userType.equals("ADMIN")){
                    AdminPageCommand adminPageCommand = new AdminPageCommand();
                    page = adminPageCommand.execute(request);
                }
                else if(userType.equals("USER")){
                    UserPageCommand userPageCommand = new UserPageCommand();
                    page = userPageCommand.execute(request);
                }

                return page;
            }
        }
        request.setAttribute("error", ErrorConstant.loginError);
        return page;
    }
}
