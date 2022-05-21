package dao.cart;

import model.Cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CartDAOImpl implements ICartDAO{

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
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public void edit(Cart cart) {

    }

    @Override
    public void delete(Cart cart) {

    }

    @Override
    public Cart findById(int id) {
        return null;
    }
}
