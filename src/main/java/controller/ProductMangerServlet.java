package controller;

import dao.product.ProductDAOImpl;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductMangerServlet", value = "/ProductMangerServlet")
public class ProductMangerServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                showProductManager(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productId = request.getParameter("productId");
        productDAO.deleteProductById(productId);
        response.sendRedirect("/ProductMangerServlet");

    }

    private void showProductManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
//        int id = user.getUser_id();
//        List<Product> list = productDAO.getProductBySellID(id);
//        request.setAttribute("listP",list);
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
        request.getRequestDispatcher("product/productManager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
