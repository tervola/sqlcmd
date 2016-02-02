package ua.com.juja.tervola.sqlcmd.service;

import ua.com.juja.tervola.sqlcmd.core.ConfigReader;
import ua.com.juja.tervola.sqlcmd.model.UserAction;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public interface Service {


    void connect(String dbName, String userName, String password) throws SQLException;

    void connect2() throws SQLException;

    void setConnectedStatus(boolean bool);

    boolean isConnected();

    String getConnectionString();

    ConfigReader getConfigReader();

    List<String> tableList() throws SQLException;

    List<List<String>> select(String command) throws SQLException;

    void executeCommand(String command) throws SQLException;


    List<UserAction> getAllfor(String userName);

    void log(UserAction userAction);

    void enablingLog(boolean cleanFlag) throws SQLException;

    boolean isLoggingEnabled();

    void setIsLoggingEnabled(boolean isLoggingEnabled);

    void closeConnection() throws SQLException;
}