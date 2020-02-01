package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

@Repository
@Scope("singleton")
public class Userrepositoryimpl implements UserRepository {


    @Autowired
    private SessionFactory sessionFactory;


    @PostConstruct
    public void init() {
        System.out.println("es init methodnem");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("es destroy nem");
    }


    @Transactional(isolation = Isolation.DEFAULT)
    public void add(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.save(user);


    }

    @Transactional(rollbackFor = Throwable.class, noRollbackFor = IndexOutOfBoundsException.class, readOnly = true)
    public void update(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public void delete(long id) throws SQLException {

    }

    @Transactional
    public void delete(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(user);


    }

    public User getByUsernameAndPassword(String username, String password) {

        Session session = sessionFactory.openSession();
        NativeQuery<User> query = session.createNativeQuery("SELECT * FROM user WHERE username = ? AND password = ? ");
        query.setParameter(1, "username");
        query.setParameter(2, "password");
        return query.uniqueResult();


    }

    public User getByUsername(String username) {

        Session session = sessionFactory.openSession();
        NativeQuery<User> query = session.createNativeQuery("SELECT * FROM user WHERE username = ?", User.class);
        query.setParameter(1, "username");
        return query.uniqueResult();

    }

    public User getById(long id) {

        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }


}




