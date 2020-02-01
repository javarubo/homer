package am.basic.web.repository;


import am.basic.web.model.User;
import am.basic.web.util.Datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryJdbc implements UserRepository {


    @Override
    public void add(User user) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into user(name, surname,username,age,code,password) VALUES (?,?,?,?,?,?);");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getAge());
        stmt.setString(5, user.getCode());
        stmt.setString(6, user.getPassword());
        stmt.execute();
    }

    @Override
    public void update(User user) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("update user set name=?,surname=?,username=?,age=?,code=? where id=?");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getAge());
        stmt.setString(5, user.getCode());
        stmt.setLong(6, user.getId());
        stmt.execute();

    }

    @Override
    public void delete(long id) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from user where id=?");
        stmt.setLong(1, id);
        stmt.execute();


    }

    @Override
    public User getByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setPassword(resultSet.getString("password"));
            user.setCode(resultSet.getString("code"));
            user.setAge(resultSet.getString("age"));
            user.setId(resultSet.getLong("id"));
        }

        return user;
    }

    @Override
    public User getByUsername(String username) throws SQLException {
User user=null;
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setString(1, username);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            user=new User();
            user.setUsername(resultSet.getString("username"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setPassword(resultSet.getString("password"));
            user.setCode(resultSet.getString("code"));
            user.setAge(resultSet.getString("age"));
            user.setId(resultSet.getLong("id"));
        }

        return user;
    }

    @Override
    public User getById(long id) {
        return null;
    }
}