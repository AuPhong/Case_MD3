package dao.product;

import model.Category;
import model.Product;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO{
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_commerce", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {
        List<Product> listProduct = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select * from product;")
                ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                Double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");

                listProduct.add(new Product(productId,productName,productPrice,productImage,
                        productDescription,quantityProduct,categoryId));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product findById(int idSearch) {
        Product product = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select * from product where product_id=?;")
        ) {
            statement.setInt(1,idSearch);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                int sellerId = rs.getInt("seller_id");
                product = new Product(productId,productName,productPrice,productImage,productDescription,quantityProduct,categoryId,sellerId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        String query = "select * from category;";
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                categoryList.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public List<Product> getTopProduct() {
        List<Product> topProduct = new ArrayList<>();
        String query = "select* from product \n" +
                "order by product_price desc limit 3;";
        try( Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                Double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");

                topProduct.add(new Product(productId,productName,productPrice,productImage,productDescription,quantityProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topProduct;
    }

    @Override
    public List<Product> getProductByCID(String category_id) {
        List<Product> productByCID = new ArrayList<>();
        String query = "select*from product\n" +
                "where category_id = ?;";
        try(
                Connection connection = getConnection();
                PreparedStatement statement =connection.prepareStatement(query);
        ) {
            statement.setString(1,category_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                Double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");

                productByCID.add(new Product(productId,productName,productPrice,productImage,productDescription,quantityProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productByCID;
    }

    @Override
    public Product getProductByID(String id) {
        String query = "select*from product\n" +
                "where product_id = ?;";
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ) {
            statement.setString(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductByID(int id) {
        String query = "select*from product\n" +
                "where product_id = ?;";
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProductByName(String productName) {
        List<Product> products = new ArrayList<>();
        String query = "select * from product where product_name like ?;";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1,"%"+productName+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName1 = rs.getString("product_name");
                Double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");

                products.add(new Product(productId,productName1,productPrice,productImage,productDescription,quantityProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public int getTotalProduct() {
        String query = "select count(*) from product;";
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select*from product\n" +
                "order by product_id limit ?,6;";
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ){
            statement.setInt(1,(index-1)*6);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                Double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");
                list.add(new Product(productId,productName,productPrice,productImage,productDescription,quantityProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductBySellID(int id) {
        List<Product> productBySellID = new ArrayList<>();
        String query = "select * from product\n" +
                "where seller_id = ?;";
        try(
                Connection connection = getConnection();
                PreparedStatement statement =connection.prepareStatement(query);
        ) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                Double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("description");
                int  quantityProduct = rs.getInt("quantity");

                productBySellID.add(new Product(productId,productName,productPrice,productImage,productDescription,quantityProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productBySellID;
    }

    public void deleteProductById (String productId) {
        String query = "delete from product where product_id = ?;";
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ){
            statement.setString(1,productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editProductByID(String name,String price,String image,String description,String quantity,String cid,String pid) {
        String query = "update product\n" +
                "set product_name = ?,\n" +
                "product_price = ?,\n" +
                "product_image = ?,\n" +
                "description = ?,\n" +
                "quantity = ?,\n" +
                "category_id = ?\n" +
                "where product_id = ?;";
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ) {
            statement.setString(1,name);
            statement.setString(2,price);
            statement.setString(3,image);
            statement.setString(4,description);
            statement.setString(5,quantity);
            statement.setString(6,cid);
            statement.setString(7,pid);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSellerIdByProductId(int productId) {
        int sellerId = 0;
        try(
                Connection connection = getConnection();
                PreparedStatement statement =connection.prepareStatement("select seller_id from product where product_id = ?;");
        ) {
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                sellerId = rs.getInt("seller_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellerId;
    }

    public static void main(String[] args) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        List<Product> list = productDAO.pagingProduct(1);
        for (Product p: list
             ) {
            System.out.println(p);
        }
    }

    public void addProduct(String pname,  String pprice,String pimage, String pdescription, String pquantity, String pcategory, int sid) {
        System.out.println();
        String query = "insert into product(product_name,product_price,product_image,description,quantity,category_id,seller_id)\n" +
                "values (?,?,?,?,?,?,?);";
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1,pname);
            statement.setString(2,pprice);
            statement.setString(3,pimage);
            statement.setString(4,pdescription);
            statement.setString(5,pquantity);
            statement.setString(6,pcategory);
            statement.setInt(7,sid);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
