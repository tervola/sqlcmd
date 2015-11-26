package ua.com.juja.tervola.sqlcmd.service;

import ua.com.juja.tervola.sqlcmd.core.ConfigReader;
import ua.com.juja.tervola.sqlcmd.core.ConnectionManager;
import ua.com.juja.tervola.sqlcmd.core.DbController;
import ua.com.juja.tervola.sqlcmd.core.DbControllerImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class ServiceImpl implements Service {
    private ConnectionManager connectionManager;
    private ConfigReader configReader;
    private DbController dbController;
    private Connection connection;
    private boolean isConnected = false;
    private boolean isLoggingEnabled = false;

    @Override
    public void enablingLog(boolean cleanFlag) throws SQLException {
        if (dbController.isExistLogTable() && cleanFlag){
            dbController.executeCommand("TRUNCATE logs");
        } else {
            dbController.executeCommand("CREATE TABLE logs (id SERIAL, timestamp timestamp, Description text");
        }
    }

    @Override
    public boolean isLoggingEnabled(){
        return isLoggingEnabled;
    }

    @Override
    public void setIsLoggingEnabled(boolean isLoggingEnabled) {
        this.isLoggingEnabled = isLoggingEnabled;
    }

    public ServiceImpl() throws IOException, SQLException {
        configReader = new ConfigReader();
    }

    @Override
    public List<String> commandsList() {
        return Arrays.asList("help", "list", "select", "select_mock", "execute");
    }

    @Override
    public List<String> connectionCommandsList() {
        return Arrays.asList("connect", "mock");
    }

    @Override
    public void connect(String dbName, String userName, String password) throws SQLException {
        connectionManager = new ConnectionManager(configReader.getConnectionStringWithouDB(), dbName, userName, password);
        connection = connectionManager.connect();
        dbController = new DbControllerImpl(connection);
        if (connectionManager != null) {
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
    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public String getConnectionString() {
        return configReader.getConnectionString();
    }

    @Override
    public ConfigReader getConfigReader() {
        return configReader;
    }

    @Override
    public List<String> tableList() throws SQLException {
        return dbController.tableList();
    }

    @Override
    public List<String[]> select(String command) throws SQLException {
        List<String[]> rval = dbController.select(command);
        addLog(command);
        return rval;

    }

    @Override
    public void executeCommand(String command) throws SQLException {
        dbController.executeCommand(command);
        addLog(command);
    }

    private void addLog(String command) throws SQLException {
        dbController.executeCommand(String.format("INSERT INTO logs(\"timestamp\", \"Details\")VALUES (CURRENT_TIMESTAMP, \'%s\')",command));
    }
}
