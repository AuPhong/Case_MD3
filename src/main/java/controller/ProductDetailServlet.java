package controller;

import dao.product.ProductDAOImpl;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet", value = "/productDetails")
public class ProductDetailServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "productID":
                showProductDetail(request,response);
        }
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productId");
        String cateID = request.getParameter("categoryId");
        Product product = productDAO.getProductByID(id);
        List<Category> categoryList = productDAO.getAllCategory();
        List<Product> topProduct = productDAO.getTopProduct();
        List<Product> productByCID = productDAO.getProductByCID(cateID);
        request.setAttribute("detail",product);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("topProduct",topProduct);
        request.setAttribute("productByCID",productByCID);
        request.getRequestDispatcher("product/productDetail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
