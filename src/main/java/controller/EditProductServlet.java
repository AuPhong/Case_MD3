package controller;

import dao.product.ProductDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditProductServlet", value = "/editProducts")
public class EditProductServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action) {
            default:
                editProduct(request,response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pprice = request.getParameter("price");
        String pdescription = request.getParameter("description");
        String pquantity = request.getParameter("quantity");
        String pcategory = request.getParameter("category");
        productDAO.editProductByID(pname,pprice,pimage,pdescription,pquantity,pcategory,pid);
        response.sendRedirect("/ProductMangerServlet");
    }
}
