package dao.cart;

import dao.IDAO;
import model.Cart;

import java.util.List;

public interface ICartDAO extends IDAO<Cart> {
    List<Cart> selectCart(int id);
    void updateCart (Cart cart);
    double subTotal(int userId);
    void deleteById(int id);

    void deleteByUserId(int userId);

    void updateQuantityStock (int quantityStock, int productId);
}
