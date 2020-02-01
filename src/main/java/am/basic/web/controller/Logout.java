package am.basic.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class Logout extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        Cookie[] cookie = request.getCookies();
        if (cookie != null)
            for (Cookie cookie1 : cookie) {
                cookie1.setValue("");
                cookie1.setPath("/");
                cookie1.setMaxAge(0);
                response.addCookie(cookie1);
            }


        response.sendRedirect("/index.jsp");

    }
}

