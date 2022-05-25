package controller;

import dao.user.UserDAOImpl;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/addUsers")
public class AddUserServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showFormAddUser(request, response);
                break;
        }
    }

    private void showFormAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create" :
                addNewUser(request, response);
                break;

        }
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        int role = Integer.parseInt(request.getParameter("role"));
        String address = request.getParameter("address");
        User newUser = new User(full_name, email, password, phone, role, address);
        userDAO.save(newUser);
        response.sendRedirect("/UserManagementServlet");
    }
}