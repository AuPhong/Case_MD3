package controller;

import dao.user.UserDAOImpl;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserManagementServlet", value = "/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAOImpl userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    showManagemenManager(request, response);
                    break;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        userDAO.deleteById(id);
        response.sendRedirect("/UserManagementServlet");
    }



    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/userManagement.jsp");
        dispatcher.forward(request, response);
    }

    private void showManagemenManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        List<User> listUser = userDAO.findAll();
//        request.setAttribute("listUser", listUser);
        String name = request.getParameter("name");
        int count = userDAO.getTotalUser();
        int endPage = count/5;
        if (count%5 != 0){
            endPage++;
        }
        String indexPage = request.getParameter("index");
        if (indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        List<User> userList;
        if (name!=null&&name!=""){
            userList = userDAO.findByName(name);

        } else {
            userList = userDAO.pagingUser(index);
        }
        request.setAttribute("listU", userList);
        request.setAttribute("endPage",endPage);
        request.setAttribute("tag",indexPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/userManagement.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchByName(request, response);
                break;
            default:
                try {
                    showManagemenManager(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<User> userList = userDAO.findByName(name);
        request.setAttribute("listU", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/userManagement.jsp");
        dispatcher.forward(request, response);
    }
}
