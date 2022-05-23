package dao.user;

import model.User;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_thuongmai1", "root", "123456");
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("insert into user(full_name,email,password,phone,Role,address) values (?,?,?,?,?,?)")) {
            statement.setString(1, user.getFull_name());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.setInt(5, user.getRole());
            statement.setString(6, user.getAddress());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveSeller(User user) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("insert into seller (seller_name,email,password,phone,Role,seller_id) values (?,?,?,?,?,?)")) {
            statement.setString(1, user.getFull_name());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.setInt(5, user.getRole());
            statement.setInt(6, user.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveBuyer(User user) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("insert into customer (customer_name,email,password,phone,Role,customer_id) values (?,?,?,?,?,?)")) {
            statement.setString(1, user.getFull_name());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.setInt(5, user.getRole());
            statement.setInt(6, user.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByEmail(String email) {
        System.out.println("finddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        User user = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("select * from user where email = ?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int Role = rs.getInt("Role");
                String address = rs.getString("address");
                user = new User(id, full_name, email, password, phone, Role, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void editRole(int id, int role) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update user where user_id=? set Role=?")) {
            statement.setInt(1,id);
            statement.setInt(2,role);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("select * from user where email=?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("email");
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("select * from user where email=? and password=?")) {
            statement.setString(1, name);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String full_name = rs.getString("full_name");
                String user_name = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("Role");
                String address = rs.getString("address");

                user = new User(full_name, user_name, password, phone, role, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
