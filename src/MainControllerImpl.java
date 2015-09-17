import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 8/28/2015.
 */
public class MainControllerImpl implements MainController {

    private String driver;
    private String serverName;
    private String port;
    private String databaseName;
    private String userName;
    private String password;

    public MainControllerImpl(String driver, String serverName, String port, String databaseName, String userName, String password, boolean usingScanner) {
        this.driver = driver;
        this.serverName = serverName;
        this.port = port;

        if (usingScanner) {
            System.out.println("Type credentials to connect to SQL server(database|username|password):");
            String credentials = new Scanner(System.in).nextLine();
            String[] line = credentials.split("\\|");
            try {
                this.databaseName = line[0].trim();
                this.userName = line[1].trim();
                this.password = line[2].trim();
            } catch (Exception e) {
                System.err.println("Wrong input type format!");
            }
        } else {
            this.databaseName = databaseName;
            this.userName = userName;
            this.password = password;
        }

    }

    @Override
    public Connection connect() {
        Connection connection = null;
        try {
            String con = driver + serverName + ":" + port + "/" + databaseName;
            connection = DriverManager.getConnection(con, userName, password);
            System.out.println(String.format("Opened database %s successfully", databaseName));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return connection;
    }

    @Override
    public String tableList(Connection connection) throws SQLException {
        String rval = "";
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, "public", null, null);
        int index =1;
        while (rs.next()) {
            rval += String.valueOf(index++) + ". " + rs.getString(3) + "\n";
        }
        return rval.substring(0, rval.length() - 1);

    }

    @Override
    public ArrayList<String[]> select(Connection connection, String sql) throws SQLException {

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<String[]> table =  createTable(rs);
        stmt.close();
        return table;
    }

    @Override
    public void executeCommand(Connection connection, String str) throws SQLException {
        doUpdateExecution(connection, str);
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doUpdateExecution(Connection connection, String str) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(str);
        stmt.close();
    }

    private ArrayList<String []> createTable(ResultSet resultSet) throws SQLException {
        ArrayList<String []> list = new ArrayList<>();
        int columnCount = resultSet.getMetaData().getColumnCount();
        if (columnCount < 0 ) return null;

        list.add(createTitle(resultSet, columnCount));

        while(resultSet.next()) {
            list.add(createBody(resultSet, columnCount));
        }

        return list;
    }

    private String[] createTitle(ResultSet resultSet, int columnCount) throws SQLException {

        String[] tableTitles = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                tableTitles[i - 1] = resultSet.getMetaData().getColumnName(i);
        }
        return tableTitles;
    }
    private String[] createBody(ResultSet resultSet, int columnCount) throws SQLException {

        String rval = "";

        for (int i = 1; i <= columnCount ; i++) {
            rval += resultSet.getString(i) + " ";
        }
        return rval.split(" ");
    }
}
