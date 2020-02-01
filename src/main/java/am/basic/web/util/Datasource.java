package am.basic.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    private static Connection connection;
    private static final String host = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "";


    public static Connection getConnection() {
        try {
            if(connection==null || connection.isClosed()){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection= DriverManager.getConnection(host,username,password);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }





        } catch (SQLException e) {
            e.printStackTrace();
        } return connection;
    }
}



