package ua.com.juja.tervola.sqlcmd.service;

import ua.com.juja.tervola.sqlcmd.ConfigReader;
import ua.com.juja.tervola.sqlcmd.ConnectionManager;
import ua.com.juja.tervola.sqlcmd.DbController;
import ua.com.juja.tervola.sqlcmd.DbControllerImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ServiceImpl implements Service {
    private ConnectionManager connectionManager;
    private ConfigReader configReader;
    private DbController dbController;
    private Connection connection;
    private boolean isConnected = false;

    public ServiceImpl() throws IOException, SQLException {
        configReader = new ConfigReader();
    }

    @Override
    public List<String> commandsList() {
        return Arrays.asList("help","menu","connect","mock","list","select","select_mock");
    }

    @Override
    public void connect(String dbName, String userName, String password) throws SQLException {
        connectionManager = new ConnectionManager(configReader.getConnectionStringWithouDB(),dbName, userName,  password);
        connection =  connectionManager.connect();
        dbController = new DbControllerImpl(connection);
        if(connectionManager != null) {
            isConnected = true;
        }
    }

    @Override
    public void connect2() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5436/MyDb", "postgres", "Password01");
            dbController = new DbControllerImpl(connection);
            isConnected = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    @Override
    public ConfigReader getConfigReader(){
        return configReader;
    }

    @Override
    public List<String> tableList() throws SQLException {
        return dbController.tableList();
    }

    @Override
    public List<String[]> select(String command) throws SQLException {
       return dbController.select(command);
    }


}
