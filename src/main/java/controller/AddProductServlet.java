package controller;

import dao.product.ProductDAOImpl;
import model.Category;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/addProducts")
public class AddProductServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                showFormAddProduct(request,response);
                break;
        }
    }

    private void showFormAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = productDAO.getAllCategory();
        request.setAttribute("categoryList",categoryList);
       RequestDispatcher dispatcher = request.getRequestDispatcher("product/addProduct.jsp");
       dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                addNewProduct(request,response);
                break;
        }
    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pname = request.getParameter("name");
        String pprice = request.getParameter("price");
        String pimage = request.getParameter("image");
        String pdescription = request.getParameter("description");
        String pquantity = request.getParameter("quantity");
        String pcategory = request.getParameter("category");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        int sid = user.getUser_id();
        productDAO.addProduct(pname,pprice,pimage,pdescription,pquantity,pcategory,sid);
        response.sendRedirect("/ProductMangerServlet");
    }
}
