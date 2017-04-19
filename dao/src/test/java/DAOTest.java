import com.netcracker.kutz.dao.UserMySQLDAO;
import com.netcracker.kutz.entity.User;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Егор on 14.04.17.
 */
public class DAOTest{
    @Test
    public void getUser(){
        UserMySQLDAO userMySQLDAO = new UserMySQLDAO();
        User user = userMySQLDAO.getByID(1);
        assertNotNull(user);
    }
}
