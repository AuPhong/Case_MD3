package dao.product;

import dao.IDAO;
import model.Category;
import model.Product;

import java.util.List;

public interface IProductDAO extends IDAO<Product> {
    List<Category> getAllCategory();
    List<Product> getTopProduct();
    List<Product> getProductByCID(String category_id);
    Product getProductByID(String id);
    List<Product> getProductByName(String productName);

    int getSellerIdByProductId (int productId);
}
