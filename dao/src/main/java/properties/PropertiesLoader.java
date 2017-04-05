package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Егор on 03.04.17.
 */
public class PropertiesLoader {

    public static void main(String[] args) {
        PropertiesLoader loader = getPropFromFile();
    }


    private String host;
    private String login;
    private String password;

    public PropertiesLoader(String host, String login, String password) {
        this.host = host;
        this.login = login;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public static PropertiesLoader getPropFromFile(){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("dao/src/main/resources/db_prop.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new PropertiesLoader(property.getProperty("db.host"),property.getProperty("db.login"),
                property.getProperty("db.password"));

    }
}
