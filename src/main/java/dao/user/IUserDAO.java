package dao.user;

import dao.IDAO;
import model.User;

public interface IUserDAO extends IDAO<User> {
    User checkLogin(String name, String pass);
    User checkRegister(String name);
}
