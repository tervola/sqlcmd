package ua.com.juja.tervola.sqlcmd.console;

import ua.com.juja.tervola.sqlcmd.core.ConfigReader;
import ua.com.juja.tervola.sqlcmd.core.ConnectionManager;
import ua.com.juja.tervola.sqlcmd.core.DbControllerImpl;
import ua.com.juja.tervola.sqlcmd.core.Table;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/15/2015.
 */
public class InformerImpl implements Informer {

    private ConnectionManager connectionManager;
    private DbControllerImpl dbController;
    private Connection connection;
    private ConfigReader configReader;

    public InformerImpl(ConnectionManager connectionManager, ConfigReader configReader) throws SQLException, IOException {
        this.connectionManager = connectionManager;
        this.configReader = configReader;
        connection = connectionManager.connect();
        dbController = new DbControllerImpl(connection);

        if (this.connectionManager == null) {
            System.out.println(connectionManager);
            System.out.println(this.connectionManager);
        }

        if (this.configReader == null) {
            System.out.println(this.configReader.toString());
            System.out.println(configReader);
        }
        if (connection == null) {
            System.out.println(connection);
        }
        if (dbController == null) {
            System.out.println(dbController);
        }
        print("Type \"help\" for command list or type command: ");
    }

    @Override
    public void help() {
        print(
                "\t" + "help: \n\t\tShow this help" + "\n" +
                        "\t" + "exit: \n\t\tOutput from the program" + "\n" +
                        "\t" + "list: \n" +
                        "\t\tList of tables into the database" + "\n" +
                        "\t" + "Select from table: \n" +
                        "\t\tSelect records from table, examples:" + "\n" +
                        "\t\t" + " \"SELECT * FROM name\"" + "\n" +
                        "\t\t" + " \"SELECT * FROM name WHERE id > 1\"" + "\n" +
                        "\t\t" + " \"SELECT id FROM name WHERE id < 1\"" + "\n" +
                        "\t" + "Insert into table: \n" +
                        "\t\t" + " \"INSERT INTO id (id_name,id_temp,country_name) VALUES (3, 'tree', 'UA');\"" + "\n" +
                        "\t\t" + " \"INSERT INTO employee (id,name,alias) VALUES (1, 'Stas', 'tervola');\"" + "\n" +
                        "\t" + "Updating records: \n" +
                        "\t\tupdating records into table" + "\n" +
                        "\t\t" + " \"UPDATE id set country_name = 'Unknown' WHERE country_name ='null';\"" + "\n" +
                        "\t" + "Deleting records: \n" +
                        "\t\t" + " \"DELETE FROM id WHERE id_name = 4;\"" + "\n" +
                        "\t" + "drop: \n" +
                        "\t\t\"DROP TABLE films, distributors;\"" + "\n" +
                        "\t" + "Create table: \n" +
                        "\t\t" + " \"CREATE TABLE COMPANY (ID INT, NAME TEXT NOT NULL, AGE INT NOT NULL)\";"
        );
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void printTable(ArrayList<String[]> table) {
        for (String[] line : table) {
            String formater = createFormater(line.length);
            System.out.format(formater, line[0], line[1], line[2]);
        }
    }

    private String createFormater(int count) {
        String formater = "|";
        for (int i = 0; i < count; i++) {
            formater += " %15s |";
        }
        return formater + "\n";
    }

    @Override
    public int parser(String string) throws SQLException {

        int rval = 0;
        if (string.trim().length() == 0 || string.isEmpty()) return rval;
        string = string.toLowerCase();

        if (string.equals("help")) {
            this.help();
            rval = 1;
        } else if (string.equals("exit")) {
            this.print("");
            this.print("Closing connection...");
            connectionManager.close();
            rval = -1;
        } else if (string.equals("list")) {
            print(String.format("\nList of tables in database: %s, on the server: %s:%s",
                    configReader.getDatabaseName(),
                    configReader.getServername(),
                    configReader.getPortNumber()));
            int index = 1;
            for (String s : dbController.tableList()) {
                print(String.valueOf(index++) + "." + s);
            }
            rval = 1;
        } else if (string.equals("selectall")) {
            string = "select * from employee";
            print(String.format("\nResult: \"%s\"", string));

            List<List<String>> list =  dbController.selectAll(string);
            for (List<String> s : dbController.selectAll(string)){
                System.out.println(s);
            }
            System.out.println("total records:" + list.size());

            rval = 1;
        } else if (string.equals("selecttable")) {
            string = "select * from employee";
            print(String.format("\nResult: \"%s\"", string));

            ArrayList<Table> tablelist  = (ArrayList<Table>) dbController.selectTable(string);

            System.out.println(tablelist.get(0).getTitle());
            for (Table s : tablelist){

                System.out.println(s.getBody().toString());
            }


            rval = 1;
        } else if (string.startsWith("select")) {
            print(String.format("\nResult: \"%s\"", string));
            printTable(dbController.select(string));
            rval = 1;
        } else {
            dbController.executeCommand(string);
            print(String.format("%s command was successfully!!!", string.split(" ")[0]));
            rval = 1;
        }
        return rval;
    }
}
