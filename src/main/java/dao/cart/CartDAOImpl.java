package dao.cart;

import model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements ICartDAO {

    public static void main(String[] args) {
        CartDAOImpl cartDAO = new CartDAOImpl();
        System.out.println(cartDAO.subTotal(5));
    }

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
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public void save(Cart cart) {
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cart (product_name, product_price, product_image, quantity, priceTotal, user_id,product_id) VALUES (?, ?, ?, ?, ?,?,?);");) {
            preparedStatement.setString(1, cart.getProductName());
            preparedStatement.setDouble(2, cart.getProductPrice());
            preparedStatement.setString(3, cart.getProductImage());
            preparedStatement.setInt(4, cart.getQuantity());
            preparedStatement.setDouble(5, cart.getPriceTotal());
            preparedStatement.setInt(6, cart.getUserId());
            preparedStatement.setInt(7, cart.getProductId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(Cart cart) {

    }

    @Override
    public void deleteByUserId(int userId) {
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from cart where user_id =?")){
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateQuantityStock(int quantityStock, int productId) {
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update product set quantity = ? where product_id = ?")){
            statement.setInt(1,quantityStock);
            statement.setInt(2, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from cart where id =?")){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Cart cart) {
    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public List<Cart> selectCart(int userid) {
        List<Cart> cartList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select  * from cart where user_id = ?;");) {
            preparedStatement.setInt(1, userid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                int quantity = rs.getInt("quantity");
                double priceTotal = rs.getDouble("priceTotal");
                String productImage = rs.getString("product_image");
                int userId = rs.getInt("user_id");
                int productId = rs.getInt("product_id");
                cartList.add(new Cart(id, productName, productPrice, quantity, priceTotal, productImage, userId, productId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }

    @Override
    public void updateCart(Cart cart) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update cart set quantity = ?, priceTotal = ? where id = ?;");) {
            preparedStatement.setInt(1, cart.getQuantity());
            preparedStatement.setDouble(2, cart.getPriceTotal());
            preparedStatement.setInt(3, cart.getCartId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double subTotal(int userId) {
        double subTotal=0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select sum(priceTotal) as sum from cart where user_id =?;");) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subTotal = resultSet.getDouble("sum");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subTotal;
    }
}
