package ua.com.juja.tervola.sqlcmd.console;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/15/2015.
 */
public interface Informer {
    void help();

    void print(String string);

    void printTable(ArrayList<String[]> table);

    int parser(String string) throws SQLException;
}
