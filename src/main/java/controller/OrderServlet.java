package controller;

import dao.Order.OrderDAOImpl;
import dao.cart.CartDAOImpl;
import dao.product.ProductDAOImpl;
import model.Cart;
import model.Order;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    OrderDAOImpl orderDAO = new OrderDAOImpl();
    CartDAOImpl cartDAO = new CartDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } switch (action){
            case "insertOrder":
                insertOrder(request,response);
                break;
        }
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("userId"));
        List<Cart> cartList = cartDAO.selectCart(customerId);
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Product product;
        for (int i = 0; i < cartList.size(); i++) {
            int sellerId = productDAO.getSellerIdByProductId(cartList.get(i).getProductId());
            Order order = new Order(sqlDate, 1, customerId, sellerId, cartList.get(i).getProductId(), cartList.get(i).getQuantity(), cartList.get(i).getPriceTotal());
            orderDAO.save(order);
            product = productDAO.getProductByID(cartList.get(i).getProductId());
            int quantityProduct = product.getQuantityProduct();
            int quantityStock = quantityProduct - cartList.get(i).getQuantity();
            cartDAO.updateQuantityStock(quantityStock, cartList.get(i).getProductId());
        }
        cartDAO.deleteByUserId(customerId);
        response.sendRedirect("/products");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
