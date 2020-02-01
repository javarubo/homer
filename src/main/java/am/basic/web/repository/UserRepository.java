package am.basic.web.repository;

import am.basic.web.model.User;

import java.sql.SQLException;

public interface UserRepository {
    void add(User user) throws SQLException;

    void update(User user) throws SQLException;

    void delete(long id) throws SQLException;

    User getByUsernameAndPassword(String username, String password) throws SQLException;

    User getByUsername(String username) throws SQLException;

    User getById(long id);
}
