import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Created by user on 9/18/2015.
 */
public class AuthCredential {

    private String databaseName;
    private String serverName;
    private String portNumber;
    private String userName;
    private String driver;
    private String password;
    Connection connection;

    public String getDatabaseName() {
        return databaseName;
    }

    public String getServerName() {
        return serverName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getDriver() {
        return driver;
    }

    public String getPassword() {
        return password;
    }

    public AuthCredential(String driver, String serverName, String portNumber, String databaseName, String userName, String password, boolean usingScanner) {
        this.driver = driver;
        this.databaseName = databaseName;
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.userName = userName;
        this.password = password;

        if (usingScanner) {
            System.out.println("Type credentials to connect to SQL server(database|username|password):");
            String credentials = new Scanner(System.in).nextLine();
            String[] line = credentials.split("\\|");

            if (line.length == 3){
                this.databaseName = line[0].trim();
                this.userName = line[1].trim();
                this.password = line[2].trim();
            } else {
                System.err.println("Wrong input type format!");
            }
        }
    }

    private Connection getConnection() {
        try {
            String con = driver + serverName + ":" + portNumber + "/" + databaseName;
            connection = DriverManager.getConnection(con, userName, password);
            System.out.println(String.format("Opened database %s successfully", databaseName));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
