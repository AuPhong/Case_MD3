package controller;

import dao.Order.OrderDAOImpl;
import dao.product.ProductDAOImpl;
import dao.user.UserDAOImpl;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderManagerServlet", value = "/OrderManagerServlet")
public class OrderManagerServlet extends HttpServlet {
    OrderDAOImpl orderDAO = new OrderDAOImpl();
    UserDAOImpl userDAO = new UserDAOImpl();
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            default:
                showOrderManager(request,response);
                break;
        }
    }

    private void showOrderManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sellerId = Integer.parseInt(request.getParameter("sellerId"));
        List<Order> orderList = orderDAO.findBySellerId(sellerId);
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("order/orderManager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
