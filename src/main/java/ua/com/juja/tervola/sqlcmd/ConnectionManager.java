package ua.com.juja.tervola.sqlcmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by user on 9/18/2015.
 */
public class ConnectionManager {
    String connectionString;
    String userName;
    String password;
    Connection connection;

    public ConnectionManager(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public ConnectionManager(String connectionStringWithoutDB, String dbName, String userName, String password) {
        this.connectionString = connectionStringWithoutDB + dbName;
        this.userName = userName;
        this.password = password;
    }

    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection(connectionString, userName, password);
        return  connection;
    }

    public void close() throws SQLException{
        connect().close();
    }
}
