package controller;

import dao.product.ProductDAOImpl;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            default:
                showProductList(request,response);
                break;
        }
    }
    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.findAll();
        List<Category> categoryList = productDAO.getAllCategory();
        List<Product> topProduct = productDAO.getTopProduct();
        request.setAttribute("listProduct",productList);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("topProduct",topProduct);
//        int count = productDAO.getTotalProduct();
//        int endPage = count/6;
//        if(count%6 != 0) {
//            endPage ++;
//        }
//        String indexPage = request.getParameter("index");
//        if (indexPage == null) {
//            indexPage = "1";
//        }
//        int index = Integer.parseInt(indexPage);
//        List<Product> list = productDAO.pagingProduct(index);
//        request.setAttribute("listA",list);
//        request.setAttribute("endPage",endPage);
//        request.setAttribute("tag",indexPage);
        request.getRequestDispatcher("product/productList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action) {
            case "search":
                showProductByName(request,response);
                break;
        }
    }

    private void showProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String productName = request.getParameter("productName");
        List<Product> products = productDAO.getProductByName(productName);
        List<Category> categoryList = productDAO.getAllCategory();
        List<Product> topProduct = productDAO.getTopProduct();
        request.setAttribute("listProduct",products);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("topProduct",topProduct);
        request.setAttribute("txtS",productName);
        request.getRequestDispatcher("product/productList.jsp").forward(request,response);
    }

}
