package ua.com.juja.tervola.sqlcmd;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


/**
 * Created by user on 9/29/2015.
 */
public class ConfigReader {
    private String SERVER_NAME;
    private String DATABASE_NAME;
    private String PORT;
    private String DRIVER;
    private String USER_NAME;
    private String PASSWORD;
    private Properties properties;
    private String fileName = "prop/config.properties";
    private boolean USING_SCANNER = false; //false - hardcoding connection params

    public ConfigReader() throws IOException, SQLException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        FileInputStream fileInputStream = new FileInputStream(file);

        properties = new Properties();
        properties.load(fileInputStream);


        SERVER_NAME = properties.getProperty("server.database.host");
        DATABASE_NAME = properties.getProperty("server.database.name");
        PORT = properties.getProperty("server.port");
        DRIVER = properties.getProperty("server.driver");
        USER_NAME = properties.getProperty("server.database.user.name");
        PASSWORD = properties.getProperty("server.database.user.password");

        if (USING_SCANNER) {
            System.out.println("Type credentials to connect to SQL server(database|username|password):");
            String credentials = new Scanner(System.in).nextLine();
            String[] line = credentials.split("\\|");

            if (line.length == 3){
                this.DATABASE_NAME = line[0].trim();
                this.USER_NAME = line[1].trim();
                this.PASSWORD = line[2].trim();
            } else {
                System.out.println("Wrong input type format!");
                System.exit(-1);
            }
        }
        fileInputStream.close();
    }

    public String getConnectionString()
    {
        return String.format("%s%s:%s/%s",DRIVER,SERVER_NAME,PORT,DATABASE_NAME);
    }

    public String getConnectionStringWithouDB()
    {
        return String.format("%s%s:%s/",DRIVER,SERVER_NAME,PORT);
    }

    public String getUserName() {
        return USER_NAME;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public Object getServername() {
        return SERVER_NAME;
    }

    public Object getPortNumber() {
        return PORT;
    }
}