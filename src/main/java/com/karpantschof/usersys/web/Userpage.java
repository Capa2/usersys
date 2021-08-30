package com.karpantschof.usersys.web;

import com.karpantschof.usersys.business.persistence.Database;
import com.karpantschof.usersys.business.persistence.UserMapper;
import entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johan
 */
@WebServlet(name = "Userpage", urlPatterns = {"/userpage"})
public class Userpage extends HttpServlet {

    private Database database;
    private UserMapper userMapper;
    private User user;

    public void init() throws ServletException {
        database = new Database("usersys");
        userMapper = new UserMapper(database);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("user", request.getAttribute("user"));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
