package entities.user;

import db.DBGetter;
import entities.Account;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Егор on 03.04.17.
 */
public class User extends AbstractUser{

    public static void main(String[] args) {
        DBGetter db = new DBGetter();
        List<User> list = db.getUserTotal();
        List<Account> accList = db.getAccount();

        System.out.println(list);
        System.out.println(accList);

        for(User user: list){
            for(Account acc: accList){
                System.out.println(user.changeBlockStatus(acc));;
            }
        }

        System.out.println(accList);
    }

    private int id;
    private int role_id;
    private String login;
    private String password;
    private String name;
    private String surname;

    public User(int id, int role_id, String login, String password, String name, String surname) {
        this.id = id;
        this.role_id = role_id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof User)) {return false;}

        User user = (User) o;

        if (id != user.id) {return false;}
        if (role_id != user.role_id) {return false;}
        if (!login.equals(user.login)) {return false;}
        if (!password.equals(user.password)) {return false;}
        if (!name.equals(user.name)) {return false;}
        return surname != null ? surname.equals(user.surname) : user.surname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + role_id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public boolean changeBlockStatus(Account acc){

        if(role_id==1){
            acc.setBlockStatus(acc.getBlockStatus()==1 ? 0 : 1);
            return true;
        }
        else{
            return false;
        }
    }
}
