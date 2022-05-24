package model;

public class OrderDetail {
    private int productId;
    private int orderId;
    private int quantityProduct;



    public OrderDetail() {
    }

    public OrderDetail(int productId, int orderId, int quantityProduct) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantityProduct = quantityProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
