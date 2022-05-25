package dao.Order;

import dao.IDAO;
import model.Order;
import model.OrderDetail;

import java.util.List;

public interface IOrderDAO extends IDAO<Order> {
    List<OrderDetail> getOrderDetailWithCustomerId (int customerId);
    void updateStatusOrder (int orderIdInput);
    List<Order> findBySellerId(int sellerId);
}

