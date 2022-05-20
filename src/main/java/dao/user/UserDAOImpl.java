package dao.user;

import dao.IDAO;
import model.User;
import org.omg.CORBA.IDLTypeHelper;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_thuongmai", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("insert into user(full_name,user_name,passWord,phone) values (?,?,?,?)")) {
            statement.setString(1, user.getFull_name());
            statement.setString(2, user.getUser_name());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }


    @Override
    public User checkRegister(String name) {
        User user = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("select * from user where user_name=?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("user_name");
                String pass1 = rs.getString("password");
                user = new User(name1, pass1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User checkLogin(String name, String pass) {
        User user = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("select * from user where user_name=? and password=?")) {
            statement.setString(1, name);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("user_name");
                String pass1 = rs.getString("password");
                user = new User(name1, pass1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
