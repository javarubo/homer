package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Cookie;
import java.sql.SQLException;


@Controller
public class Testcontroller {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String test() {

        return "index";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();

        return new ModelAndView("index", "abll", "you are logouted");

    }



    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ModelAndView login(@RequestParam String username,
                              @RequestParam("pass") String password,
                              HttpSession session, @CookieValue(value = "username", required = false) String str)
            throws SQLException {


        User user = userRepository.getByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("ttg", user);
            return new ModelAndView("profile");
        }
        return new ModelAndView("index", "abcd", "Wrongggg username!!!");
    }


    @RequestMapping(method = RequestMethod.POST, path = "/registration")

    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam String username,
                                @RequestParam String age,
                                @RequestParam String code,
                                @RequestParam String password, HttpSession session
    ) throws SQLException {
        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setAge(age);
        user.setCode(code);
        user.setPassword(password);


        userRepository.add(user);
        session.setAttribute("ttgh", user);

        return new ModelAndView("registr", "abab", "THe user added");
    }


}
