package com.netcracker.kutz.command;

import com.netcracker.kutz.enumeration.CommandEnum;
import com.netcracker.kutz.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;

import static com.netcracker.kutz.constant.ParameterConstant.actionParameter;

/**
 * Created by Егор on 21.04.17.
 */
public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
// извлечение имени команды из запроса
        String action = request.getParameter(actionParameter);
        if (action == null || action.isEmpty()) {
// если команда не задана в текущем запросе
            return current;
        }
// получение объекта, соответствующего команде
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {

        }
        return current;
    }
}
