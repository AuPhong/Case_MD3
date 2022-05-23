package model;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String productImage;
    private String productDescription;
    private int quantityProduct;
    private int categoryId;
    private int sellerId;

    public Product() {
    }

    public Product(int productId, String productName, double productPrice, String productImage, String productDescription, int quantityProduct, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.quantityProduct = quantityProduct;
        this.categoryId = categoryId;
    }

    public Product(int productId, String productName, double productPrice, String productImage, String productDescription, int quantityProduct) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.quantityProduct = quantityProduct;
    }

    public Product(int productId, String productName, double productPrice, String productImage, String productDescription, int quantityProduct, int categoryId, int sellerId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.quantityProduct = quantityProduct;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productImage='" + productImage + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityProduct=" + quantityProduct +
                ", categoryId=" + categoryId +
                '}';
    }
}
