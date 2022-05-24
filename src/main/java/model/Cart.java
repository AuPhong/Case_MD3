package model;

public class Cart {
    private int cartId;
    private String productName;
    private double productPrice;
    private int quantity;
    private double priceTotal;
    private String productImage;
    private int userId;
    private int productId;

    public Cart() {
    }

    public Cart(int cartId, int quantity, double priceTotal) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.priceTotal = priceTotal;
    }

    public Cart(String productName, double productPrice, int quantity, double priceTotal, String productImage, int userId, int productId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.priceTotal = priceTotal;
        this.productImage = productImage;
        this.userId = userId;
        this.productId = productId;
    }

    public Cart(int cartId, String productName, double productPrice, int quantity, double priceTotal, String productImage, int userId, int productId) {
        this.cartId = cartId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.priceTotal = priceTotal;
        this.productImage = productImage;
        this.userId = userId;
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", priceTotal=" + priceTotal +
                ", productImage='" + productImage + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                '}' + "\n";
    }
}
