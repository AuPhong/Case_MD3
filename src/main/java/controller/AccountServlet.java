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
                register(request, response);
                break;
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("password");
        String rePass = request.getParameter("rePassword");
        if (!pass.equals(rePass)) {
            request.setAttribute("error","Retype password not match!");
            request.getRequestDispatcher("account/login.jsp").forward(request, response);
        } else {
            User user = userDAO.checkRegister(userName);
            if (user!=null){
                request.setAttribute("error1","User name is already exist!");
                request.getRequestDispatcher("account/login.jsp").forward(request, response);
            } else {
                request.setAttribute("success","Successful!");
                userDAO.save(new User(fullName,userName,pass,phone));
                request.getRequestDispatcher("account/login.jsp").forward(request, response);
            }
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        User user = userDAO.checkLogin(name, pass);
        if (user == null) {
            request.setAttribute("mess", "Wrong username or password");
            request.getRequestDispatcher("account/login.jsp").forward(request, response);
//            response.sendRedirect("accounts");
        } else {
            response.sendRedirect("products");
        }

    }
}
