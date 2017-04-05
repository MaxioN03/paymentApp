package entities.user;

/**
 * Created by Егор on 03.04.17.
 */
public class UserDTO extends AbstractUser{
    private int role_id;
    private String login;
    private String name;
    private String surname;

    public UserDTO(int role_id, String login, String name, String surname) {
        this.role_id = role_id;
        this.login = login;
        this.name = name;
        this.surname = surname;
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
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;

        UserDTO userDTO = (UserDTO) o;

        if (role_id != userDTO.role_id) return false;
        if (!login.equals(userDTO.login)) return false;
        if (!name.equals(userDTO.name)) return false;
        return surname.equals(userDTO.surname);
    }

    @Override
    public int hashCode() {
        int result = role_id;
        result = 31 * result + login.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "role_id=" + role_id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
