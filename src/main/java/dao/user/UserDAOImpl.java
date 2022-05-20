package dao.user;

import dao.IDAO;
import model.User;
import org.omg.CORBA.IDLTypeHelper;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private String jdbcURL ="jdbc:mysql://localhost:3306/db_thuongmai?useURL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO user"+"(full_name,user_name,password,phone,role) VALUES" + "(?,?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "select id, full_name,user_name,password,phone,role from user where id=?";
    private static final String SELECT_ALL_USERS = "select*from user;";
    private static final String DELETE_USERS_SQL = "delete from user where id=?;";
    private static final String UPDATE_USERS_SQL = "update user set full_name=?, user_name=?, password=?, phone=?,role=? where id=?;";

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
//>>>>>>> 68453075ca263b3a9ba0968f40b5e14257e3075c

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
    public boolean edit(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
        ) {
            statement.setString(1,user.getFull_name());
            statement.setString(2,user.getUser_name());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getPhone());
            statement.setString(5, user.getRole());
            statement.setInt(6,user.getUser_id());

            rowUpdated = statement.executeUpdate()>0;
        }
        return rowUpdated;

    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
        ) {
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate()>0;
        }
        return rowDeleted;
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
