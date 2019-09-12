package z.ivan.service.user;

import org.springframework.stereotype.Service;
import z.ivan.dao.UserDao;
import z.ivan.model.User;


@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getByLogin(String login){
        return userDao.getByLogin(login);
    }
}
