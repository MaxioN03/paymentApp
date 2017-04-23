package com.netcracker.kutz.command;

import com.netcracker.kutz.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Егор on 21.04.17.
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        /* в случае ошибки или прямого обращения к контроллеру
* переадресация на страницу ввода логина */
        String page = "/view/error/404.jsp";
        return page;
    }
}
