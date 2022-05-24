package controller;

import dao.user.UserDAOImpl;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditUserServlet", value = "/editUsers")
public class EditUserServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                editUser(request, response);
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        int role = Integer.parseInt(request.getParameter("role"));
        String address = request.getParameter("address");
        User book = new User(id, full_name, email, password, phone, role, address);
        userDAO.edit(book);
        request.setAttribute("user", book);
        response.sendRedirect("/UserManagementServlet");
    }
}
