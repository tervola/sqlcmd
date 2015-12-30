package ua.com.juja.tervola.sqlcmd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.juja.tervola.sqlcmd.core.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceImpl implements Service {
    private ConnectionManager connectionManager;
    @Autowired
    private ConfigReader configReader;
    @Autowired
    private Menu menu;
    private DbController dbController;
    private Connection connection;
    private boolean isConnected = false;
    private boolean isLoggingEnabled = false;

    @Override
    public void enablingLog(boolean cleanFlag) throws SQLException {
        if (dbController.checkTable("logs") && cleanFlag) {
            dbController.executeCommand("TRUNCATE logs");
        } else {
            dbController.executeCommand("CREATE TABLE logs (id SERIAL, timestamp timestamp, Description text");
        }
    }

    @Override
    public boolean isLoggingEnabled() {
        return isLoggingEnabled;
    }

    @Override
    public void setIsLoggingEnabled(boolean isLoggingEnabled) {
        this.isLoggingEnabled = isLoggingEnabled;
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
    public void closeConnection() throws SQLException {
        connection.close();
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
    public List<List<String>> select(String sqlCommand) throws SQLException {

        Table table = new Table(dbController, sqlCommand);

        List<List<String>> rval = new ArrayList<>();

        for (List<String> row : table.getTable()) {
            rval.add(row);
        }
//        List<String> title = dbController.getTitle(command);
//        rval.add(title);
//        List<Rows> tablelist = dbController.select(command);
//        for (Rows s : tablelist) {
//            rval.add(s.getBody());
//        }
        return rval;

    }

    @Override
    public void executeCommand(String command) throws SQLException {
        dbController.executeCommand(command);
    }

}
