package controller;

import dao.user.UserDAOImpl;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            default:
                showLoginPage(request, response);
                break;
        }


    }


    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("account/login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                checkLogin(request, response);
                break;
            case "register":
                register(request,response);
                break;
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {

    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        User user = userDAO.checkLogin(name, pass);
        if (user == null) {
            request.setAttribute("mess","Wrong username or password");
            request.getRequestDispatcher("account/login.jsp").forward(request,response);
//            response.sendRedirect("accounts");
        } else {
            response.sendRedirect("products");
        }

    }
}
