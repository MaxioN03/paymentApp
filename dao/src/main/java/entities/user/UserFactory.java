package entities.user;

import java.util.List;

/**
 * Created by Егор on 03.04.17.
 */
public interface UserFactory {
    List<? extends AbstractUser> getUser(String access);
}
