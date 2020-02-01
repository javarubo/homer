package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryJdbc;
import am.basic.web.repository.Userrepositoryimpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class Start extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getCookies() == null) {
            response.sendRedirect("/index.jsp");
        } else {
            String username = null;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("keyc")) {
                    username = cookie.getValue();
                }
            }

            if (username == null) {
                response.sendRedirect("/index.jsp");
            } else {
                UserRepository userRepository = new Userrepositoryimpl();



                User user = new User();
                try {
                    user = userRepository.getByUsername(username);
                    HttpSession session=request.getSession();

                    session.setAttribute("user", user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    response.sendRedirect("/secure/home.html");

                }
            }

        }
    }


