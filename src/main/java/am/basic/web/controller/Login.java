package am.basic.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryJdbc;
import am.basic.web.repository.Userrepositoryimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Login extends HttpServlet {


    private UserRepository userRepository = new Userrepositoryimpl();




    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        User user = null;
        try {
            user = userRepository.getByUsernameAndPassword(username, password);

            if (user == null) {
                request.setAttribute("abcd", "WRONG USER NAME AND PAsSWORD");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                //  response.getWriter().println("Wrong username or password");
            } else {

                session.setAttribute("user", user);

                Cookie cookie = new Cookie("keyc", user.getUsername());////////////////////
                cookie.setMaxAge(3600 * 24);
                response.addCookie(cookie);


            }


            response.sendRedirect("/secure/home.html");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
