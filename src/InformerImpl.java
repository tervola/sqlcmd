import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 9/15/2015.
 */
public class InformerImpl implements Informer {

    private AuthCredential authCredential;
    private MainControllerImpl mainController;
    private Connection connection;

    public InformerImpl(AuthCredential authCredential) {
        this.authCredential = authCredential;
        this.mainController = new MainControllerImpl(authCredential);
        this.connection = mainController.connect();
        print("Type \"help\" for command list or type command: ");
    }

    @Override
    public void help() {
        print(

                "\t" + "help: \n\t\tShow this help" + "\n" +
                "\t" + "list: \n" +
                "\t\tList of tables into the database" + "\n" +
                "\t" + "Select from table: \n" +
                "\t\tSelect records from table, examples:" + "\n" +
                "\t\t" + " \"SELECT * FROM name\"" + "\n" +
                "\t\t" + " \"SELECT * FROM name WHERE id > 1\"" + "\n" +
                "\t\t" + " \"SELECT id FROM name WHERE id < 1\"" + "\n" +
                "\t" + "Insert into table: \n" +
                "\t\t" + " \"INSERT INTO id (id_name,id_temp,country_name) VALUES (3, 'tree', 'UA');\"" + "\n"+
                "\t\t" + " \"INSERT INTO employee (id,name,alias) VALUES (1, 'Stas', 'tervola');\"" + "\n"+
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
    public void print(String string){
        System.out.println(string);
    }

    @Override
    public void printTable(ArrayList<String[]> table){
        for (String[] line : table) {
            String formater = createFormater (line.length);
            System.out.format(formater, line[0] , line[1], line[2]);
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
    public int parser(String string) throws SQLException{
        int rval = 0;
        string = string.toLowerCase();

        if (string.equals("help")){
            this.help();
            rval = 1;
        } else if (string.equals("exit")) {
            this.print("");
            this.print("Closing connection...");
            mainController.close(connection);
            rval = -1;
        } else if (string.equals("list")) {
            print(String.format("\nList of tables in database: %s, on the server: %s:%s",
                    authCredential.getDatabaseName(),
                    authCredential.getServerName(),
                    authCredential.getPortNumber()));
            print(mainController.tableList(connection));
            rval = 1;
        } else if (string.startsWith("select"))  {
            print(String.format("\nResult: \"%s\"", string));
            rval = 1;
            printTable(mainController.select(connection, string));
        } else {
                mainController.executeCommand(connection, string);
                print(String.format("%s command was successfully!!!",string.split(" ")[0]));
                rval = 1;
        }
        return rval;
    }
}
