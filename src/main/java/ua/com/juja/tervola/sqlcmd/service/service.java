package ua.com.juja.tervola.sqlcmd.service;

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
}
