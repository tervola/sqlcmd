package ua.com.juja.tervola.sqlcmd.service;

import ua.com.juja.tervola.sqlcmd.ConfigReader;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public interface Service {
    List<String> commandsList();

    void connect(String dbName, String userName, String password) throws SQLException;

    void connect2() throws SQLException;

    void setConnectedStatus(boolean bool);

    boolean isConnected();

    String getConnectionString();

    ConfigReader getConfigReader();

    List<String> tableList() throws SQLException;

    List<String[]> select(String command) throws SQLException;

    void executeCommand(String command) throws SQLException;

    Object connectionCommandsList();
}