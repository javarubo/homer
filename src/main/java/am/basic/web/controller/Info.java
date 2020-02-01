package am.basic.web.controller;

import am.basic.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class Info extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");






        response.getWriter().println(user.getName());
        response.getWriter().println(user.getSurname());
        response.getWriter().println(user.getUsername());
        response.getWriter().println(user.getAge());
        response.getWriter().println(user.getCode());
        response.getWriter().println(user.getPassword());



    }
}
