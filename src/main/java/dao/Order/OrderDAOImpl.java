package dao.Order;

import model.Order;
import model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    private static final String SELECT_ALL_ORDER = "select o.order_id, o.status, o.date, c.customer_name, s.seller_name\n" +
            "from tbl_order as o join\n" +
            "customer as c on o.customer_id = c.customer_id\n" +
            "join seller as s on o.seller_id = s.seller_id;";
    private static final String SELECT_ORDERDETAIL_WITH_CUSTOMERID = "";
    private static final String SELECT_ORDER_BY_ORDERID = "select o.order_id, o.status, o.date, c.customer_name, s.seller_name\n" +
            "from tbl_order as o join\n" +
            "customer as c on o.customer_id = c.customer_id\n" +
            "join seller as s on o.seller_id = s.seller_id\n" +
            "where o.order_id = ?;";
    private static final String UPDATE_STATUS_ORDER = "update tbl_order set status = false where order_id = ?;";


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
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_order");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                int status = resultSet.getInt("status");
                Date date = resultSet.getDate("date");
                int customer_id = resultSet.getInt("customer_id");
                double priceTotal = resultSet.getDouble("priceTotal");
                int seller_id = resultSet.getInt("seller_id");
                int product_id = resultSet.getInt("productId");
                int productQuantity = resultSet.getInt("productQuantity");
                Order order = new Order(order_id, date, status, customer_id, seller_id,product_id,productQuantity,priceTotal);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }



    @Override
    public void save(Order order) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("insert into tbl_order (status,date,customer_id,priceTotal,seller_id,productId,productQuantity) values (1,?,?,?,?,?,?)"))  {
            statement.setDate(1, (Date) order.getOrderDate());
            statement.setInt(2,order.getCustomerId());
            statement.setDouble(3,order.getTotalPrice());
            statement.setInt(4,order.getSellerId());
            statement.setInt(5,order.getProductId());
            statement.setInt(6,order.getProductQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public Order findById(int orderIdInput) {
        Order order = null;
//        try {
//            Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ORDERID);
//            preparedStatement.setInt(1, orderIdInput);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int orderId = resultSet.getInt("o.orderId");
//                Date orderDate = resultSet.getDate("o.date");
//                int customerName = resultSet.getInt("c.customer_name");
//                boolean status = resultSet.getBoolean("o.status");
//                int sellerName = resultSet.getInt("s.seller_name");
//                order = new Order(orderId, orderDate, customerName, sellerName, status);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return order;
    }

    @Override
    public List<OrderDetail> getOrderDetailWithCustomerId(int customerId) {
        List<OrderDetail> orderDetailList = null;
//        try {
//            Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERDETAIL_WITH_CUSTOMERID);
//            preparedStatement.setInt(1, customerId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int orderId = resultSet.getInt("o.orderId");
//                Date orderDate = resultSet.getDate("o.date");
//                int userId = resultSet.getInt("o.userId");
//                boolean status = resultSet.getBoolean("o.status");
//                String userName = resultSet.getString("a.name");
////                Order order = new Order(orderId, orderDate, userId, userName, status,);
////                orderList.add(order);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return orderDetailList;
    }

    @Override
    public void updateStatusOrder(int orderIdInput) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_ORDER);
            preparedStatement.setInt(1, orderIdInput);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findBySellerId(int sellerId) {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_order where seller_id=?");
            preparedStatement.setInt(1,sellerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                int status = resultSet.getInt("status");
                Date date = resultSet.getDate("date");
                int customer_id = resultSet.getInt("customer_id");
                double priceTotal = resultSet.getDouble("priceTotal");
                int seller_id = resultSet.getInt("seller_id");
                int product_id = resultSet.getInt("productId");
                int productQuantity = resultSet.getInt("productQuantity");
                Order order = new Order(order_id, date, status, customer_id, seller_id,product_id,productQuantity,priceTotal);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }


}
