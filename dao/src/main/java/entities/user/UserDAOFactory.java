package entities.user;

import db.DBGetter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 03.04.17.
 */
public class UserDAOFactory implements UserFactory {

    //todo функция чтения из БД конкретных списков

    public List<? extends AbstractUser> getUser(String access) {
        DBGetter db  = new DBGetter();
        if("Total".equals(access)){
            return db.getUserTotal();
        }   else if("DTO".equals(access)){
            return db.getUserDTO();
        }

        return null;
    }
}
