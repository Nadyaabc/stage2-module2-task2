package com.example.servlet;


import com.example.Users;
import com.example.filter.AuthFilter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getAttribute("user") == null){
            response.sendRedirect("/login.jsp");

        }
        else{
            response.sendRedirect("/user/hello.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = Users.getInstance();
        List<String> stringList = users.getUsers();
        if (stringList.contains(req.getParameter("login")) && !req.getParameter("password").isEmpty()&& !(req.getParameter("password").trim().isEmpty())){
            req.setAttribute("user", req.getParameter("login"));
            resp.sendRedirect("/user/hello.jsp");
        }
        else {
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}