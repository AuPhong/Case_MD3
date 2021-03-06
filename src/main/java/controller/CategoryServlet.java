package controller;

import dao.product.ProductDAOImpl;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/categorys")
public class CategoryServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "cateID":
                listProductByCID(request,response);
        }
    }

    private void listProductByCID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cateID = request.getParameter("categoryId");
        List<Product> productByCID = productDAO.getProductByCID(cateID);
        List<Category> categoryList = productDAO.getAllCategory();
        List<Product> topProduct = productDAO.getTopProduct();
        request.setAttribute("listProduct",productByCID);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("topProduct",topProduct);
        int count = productDAO.getTotalProduct();
        int endPage = count/6;
        if(count%6 != 0) {
            endPage ++;
        }
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        List<Product> list = productDAO.pagingProduct(index);
        request.setAttribute("listA",list);
        request.setAttribute("endPage",endPage);
        request.setAttribute("tag",indexPage);
        request.getRequestDispatcher("product/productList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
