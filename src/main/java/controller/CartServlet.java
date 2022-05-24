package controller;

import dao.cart.CartDAOImpl;
import dao.product.ProductDAOImpl;
import model.Cart;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {

    ProductDAOImpl productDAO = new ProductDAOImpl();
    CartDAOImpl cartDAO = new CartDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                insertCart(request, response);
                break;
            case "delete":
                deleteCart(request,response);
                break;
            default:
                showCart(request, response);
                break;
        }
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("id"));
        cartDAO.deleteById(cartId);
        showCart(request, response);
    }

    private void insertCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDAO.findById(productId);
        int userId = Integer.parseInt(request.getParameter("session"));
        int quantity = 1;
        boolean isExist = false;
        int cartId = 0;
        double priceTotal = 0;

        List<Cart> cartList = cartDAO.selectCart(userId);
        for (Cart cart: cartList) {
            if (cart.getProductId() == productId) {
                quantity = cart.getQuantity() + 1;
                isExist = true;
                cartId = cart.getCartId();
                priceTotal = quantity * cart.getProductPrice();
            }
        }
        if (isExist) {
            Cart cart = new Cart(cartId, quantity, priceTotal);
            cartDAO.updateCart(cart);
        } else {
            Cart cart = new Cart(product.getProductName(), product.getProductPrice(), quantity, product.getProductPrice(), product.getProductImage(), userId, product.getProductId());
            cartDAO.save(cart);
        }
        response.sendRedirect("products");
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        int userId = user.getUser_id();
        double subTotal = cartDAO.subTotal(userId);
        List<Cart> cartList = cartDAO.selectCart(userId);
        request.setAttribute("cartList",cartList);
        request.setAttribute("subTotal",subTotal);
        request.getRequestDispatcher("order/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
