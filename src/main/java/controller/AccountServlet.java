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
            case "logout":
                logout(request, response);
                break;
            default:
                showLoginPage(request, response);
                break;
        }


    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        response.sendRedirect("home");
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
            case "editRole":
                editRole(request,response);
                break;
        }
    }

    private void editRole(HttpServletRequest request, HttpServletResponse response) {
        String roleName = request.getParameter("role");
        int id;
        int role;
        if (roleName.equals("Buyer")){

        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int role;
        String fullName = request.getParameter("fullName");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("password");
        String rePass = request.getParameter("rePassword");
        String roleString = request.getParameter("role");
        String address = request.getParameter("address");
        if (roleString.equals("Buyer")) {
            role = 1;
        } else if (roleString.equals("Seller")) {
            role = 2;
        } else {
            role = 1;
        }
        if (!pass.equals(rePass)) {
            request.setAttribute("error", "Retype password not match!");
            request.getRequestDispatcher("account/login.jsp").forward(request, response);
        } else {
            User user = userDAO.checkRegister(userName);
            if (user != null) {
                request.setAttribute("error1", "This email is already exist!");
                request.getRequestDispatcher("account/login.jsp").forward(request, response);
            } else {
                request.setAttribute("success", "Successful!");
                userDAO.save(new User(fullName, userName, pass, phone, role, address));
                request.getRequestDispatcher("account/login.jsp").forward(request, response);
//                String email = user.getEmail();
                User userSave = userDAO.findByEmail(userName);
                if (userSave.getRole() == 1) {
                    userDAO.saveBuyer(userSave);
                } else if (userSave.getRole() == 2) {
                    userDAO.saveSeller(userSave);
                }

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
            HttpSession session = request.getSession();
            session.setAttribute("account", user);
            response.sendRedirect("home");
        }

    }
}
