package com.netcracker.kutz.entity;


import com.netcracker.kutz.enums.UserType;

public class User{
    private int id;
    private UserType userType;
    private String login;
    private String password;
    private String name;
    private String surname;

    public User() {
    }

    public User(int id, UserType userType, String login, String password, String name, String surname) {
        this.id = id;
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(UserType userType, String login, String password, String name, String surname) {
        this.userType = userType;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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
        if (userType != user.userType) {return false;}
        if (!login.equals(user.login)) {return false;}
        if (!password.equals(user.password)) {return false;}
        if (!name.equals(user.name)) {return false;}
        return surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userType.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", userType=").append(userType);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
