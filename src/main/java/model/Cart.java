package model;

public class Cart {
    private int cartId;
    private String productName;
    private float productPrice;
    private int quantity;
    private float priceTotal;
    private String productImage;
    private int userId;
    private int productId;

    public Cart() {
    }

    public Cart(int cartId, String productName, float productPrice, int quantity, float priceTotal, String productImage, int userId, int productId) {
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

    public float getProductPrice() {
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

    public float getPriceTotal() {
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
}
