package dao.Order;

import model.Order;
import model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    private static final String SELECT_ALL_ORDER = "";
    private static final String SELECT_ORDERDETAIL_WITH_CUSTOMERID = "";

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
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("o.orderId");
                Date orderDate = resultSet.getDate("orderDate");
                int userId = resultSet.getInt("o.userId");
                boolean status = resultSet.getBoolean("status");
                String userName = resultSet.getString("a.name");
//                Order order = new Order(orderId, orderDate, userId, userName, status,);
//                orderList.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }


    @Override
    public void save(Order order) {

    }

    @Override
    public void edit(Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public Order findById(int id) {
        return null;
    }

    public OrderDetail getOrderDetailWithCustomerId (int customerId) {
        OrderDetail orderDetail = new OrderDetail();
        return orderDetail;
    }
}
