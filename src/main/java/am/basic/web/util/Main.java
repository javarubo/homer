package am.basic.web.util;


import am.basic.web.model.PhoneNumber;
import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryJdbc;
import am.basic.web.repository.Userrepositoryimpl;
import am.basic.web.service.UserService;
import am.basic.web.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(1);

UserService userService= applicationContext.getBean(UserService.class);
        System.out.println(2);
UserService userService1= applicationContext.getBean(UserService.class);


        System.out.println(userService);
        System.out.println(userService1);

        System.out.println(userService.getUserRepository());
        System.out.println(userService1.getUserRepository());





















































       /* UserRepository userRepository = new Userrepositoryimpl();
        UserRepository userRepository1 = new UserRepositoryJdbc();


        UserService userService=new UserServiceImpl(userRepository);
        UserService userService1=new UserServiceImpl(userRepository1);
       userService.getByUsername("nv");*/


























































        /*Userrepositoryimpl userrepositoryimpl = new Userrepositoryimpl();

        User user = new User();
        user.setName("Ruben");
        user.setUsername("Ruben");
        user.setSurname("Ruben");
        user.setAge("Ruben");
        user.setCode("Ruben");
        user.setPassword("Ruben");

        PhoneNumber phoneNumber = new PhoneNumber("VIVA", 94456232);
        PhoneNumber phoneNumber1 = new PhoneNumber("mts", 98555514);

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        phoneNumbers.add(phoneNumber1);

        user.setPhoneNumber(phoneNumbers);

        userrepositoryimpl.add(user);
*/

    }


}
