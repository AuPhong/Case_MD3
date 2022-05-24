package controller;

import dao.cart.CartDAOImpl;
import model.Cart;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutServlet", value = "/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    CartDAOImpl cartDAO = new CartDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "insertOrder":
                insertOrder(request, response);
                break;
            default:
                showCheckOut(request,response);
                break;
        }

    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCheckOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        int userId = user.getUser_id();
        double subTotal = cartDAO.subTotal(userId);
        List<Cart> cartList = cartDAO.selectCart(userId);
        request.setAttribute("user", user);
        request.setAttribute("cartList",cartList);
        request.setAttribute("subTotal",subTotal);
        request.getRequestDispatcher("order/checkOut.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
