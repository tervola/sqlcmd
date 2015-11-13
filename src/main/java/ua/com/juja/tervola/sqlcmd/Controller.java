package ua.com.juja.tervola.sqlcmd;

import ua.com.juja.tervola.sqlcmd.Informer;
import ua.com.juja.tervola.sqlcmd.InformerImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by user on 8/28/2015.
 */
public class Controller {
    ConnectionManager connectionManager;
    Informer informer;
    ConfigReader configReader;

    public void run() throws SQLException, IOException {
        configReader = new ConfigReader();
        try {
            connectionManager = new ConnectionManager(configReader.getConnectionString(), configReader.getUserName(), configReader.getPassword());
            informer = new InformerImpl(connectionManager,configReader);
            informer.print(String.format("Opened database %s successfully", configReader.getDatabaseName()));
            informer.print(String.format("Driver:%s", configReader.getConnectionString()));
        } catch (Exception e){
            informer = new InformerImpl(connectionManager, configReader);
            informer.print(e.getClass().getName() + ": " + e.getMessage());
            System.exit(-1);
        }

        int code = 0;
        while (code >=0 ) {
            informer.print("Input command():");
            try {
                code = informer.parser(new Scanner(System.in).nextLine());
            } catch (SQLException error) {
                errorHandler(error);
            }
            if(code == 0) System.err.println("Try again or type \"help\"");
        }
    }

    private static void errorHandler(SQLException error) {
        String[] errorMessage = error.getMessage().split("\n");

        for (int i = 0; i < errorMessage.length - 1 ; i++) {
            System.err.print(errorMessage[i] + ". ");
        }
    }
}
