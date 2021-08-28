/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karpantschof.usersys.business.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    private final String USER;
    private final String PASSWORD;
    private final String URL;

    public Database(String db) {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            USER = System.getenv("USER");
            PASSWORD = System.getenv("PW");
            URL = System.getenv("CONNECTION_STR") + db + "?serverTimezone=CET";
        } else {
            USER = "dev";
            PASSWORD = "ax2";
            URL = "jdbc:mysql://localhost:3306/" + db + "?serverTimezone=CET";
        }
    }

    public Connection connect() throws SQLException, ClassNotFoundException {
        if ((connection == null) || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }

}
