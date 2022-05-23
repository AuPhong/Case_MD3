package dao.user;

import dao.IDAO;
import model.User;

public interface IUserDAO extends IDAO<User> {
    User checkLogin(String name, String pass);
    User checkRegister(String name);
    void saveSeller(User user);
    void saveBuyer(User user);
    User findByEmail(String email);
    void editRole(int id, int role);
}
