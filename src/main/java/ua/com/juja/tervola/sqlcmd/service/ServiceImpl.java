package ua.com.juja.tervola.sqlcmd.service;

import ua.com.juja.tervola.sqlcmd.ConfigReader;
import ua.com.juja.tervola.sqlcmd.ConnectionManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public class ServiceImpl implements Service {
    private ConnectionManager connectionManager;
    private ConfigReader configReader;
    private boolean isConnected = false;

    public ServiceImpl() throws IOException, SQLException {
        configReader = new ConfigReader();
    }

    @Override
    public List<String> commandsList() {
        return Arrays.asList("help","menu","connect","mock");
    }

    @Override
    public void connect(String dbName, String userName, String password) throws SQLException {
        connectionManager = new ConnectionManager(configReader.getConnectionStringWithouDB(),dbName, userName,password);
        connectionManager.connect();
    }

    @Override
    public void connect2() throws SQLException {
        connectionManager = new ConnectionManager(configReader.getConnectionString(),configReader.getUserName(),configReader.getPassword());
        connectionManager.connect();
    }

    @Override
    public void setConnectedStatus(boolean bool) {
        this.isConnected = bool;
    }

    @Override
    public boolean isConnected(){
        return isConnected;
    }

    @Override
    public String getConnectionString() {
        return configReader.getConnectionString();
    }
}
