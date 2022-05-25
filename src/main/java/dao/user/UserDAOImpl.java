package dao.user;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private static final String SELECT_USER_BY_NAME="select user_id,full_name,email,password, phone, role, address from user where full_name like ?";
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (full_name, email, password,phone,role,address) VALUES " +
            " (?, ?, ?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "select user_id,full_name, email, password,phone,role,address from user where user_id =?";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String DELETE_USERS_SQL = "delete from user where user_id = ?;";
    private static final String UPDATE_USERS_SQL = "update user set full_name =?, email=?, password=?,phone=?,role=?,address=? where user_id = ?;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_commerce", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
        //using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String address = rs.getString("address");
                users.add(new User(id, full_name, email, password, phone, role, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
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
    public void deleteById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(User user) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFull_name());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.setInt(5, user.getRole());
            statement.setString(6, user.getAddress());
            statement.setInt(7, user.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editPassword(int id, String password) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update user set password=? where user_id=? ")) {
            statement.setString(1,password);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editRole(int id, int role) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update user set role=? where user_id=? ")) {
            statement.setInt(1,role);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {

    }

    public List<User> findByName(String nameSearch) {
        List<User> userList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {
            preparedStatement.setString(1,"%" + nameSearch + "%");
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id= rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String address = rs.getString("address");
                userList.add(new User(id, full_name, email, password, phone, role,address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public int getTotalUser() throws SQLException {
        String query = "select count(*) from user;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return  rs.getInt(1);
            }
        }
        return 0;
    }
    public List<User> pagingUser(int index){
        List<User> list = new ArrayList<>();
        String query = "select*from user\n" +
                "order by user_id limit ?, 5";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, (index-1)*5);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String address = rs.getString("address");

                list.add(new User(id, full_name,email,password,phone,role,address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public User findById(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String full_name = rs.getString("full_name" +
                        "");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String address = rs.getString("address");
                user = new User(id, full_name, email, password, phone, role, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
                int id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String user_name = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("Role");
                String address = rs.getString("address");

                user = new User(id,full_name, user_name, password, phone, role, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
