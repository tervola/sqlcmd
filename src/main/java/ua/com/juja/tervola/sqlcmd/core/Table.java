package ua.com.juja.tervola.sqlcmd.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/30/2015.
 */
public class Table {
    List<List<String>> tableResult;
    DbController dbController;
    String sqlCommand;

    public Table(DbController dbController, String sqlCommand) {
        this.dbController = dbController;
        this.sqlCommand = sqlCommand;
        tableResult = new ArrayList<>();
    }

    public List<List<String>> getTable() throws SQLException {
        tableResult.add(dbController.getTitle(sqlCommand));

        List<Rows> tablelist  = dbController.select(sqlCommand);

        for (Rows s : tablelist) {
            tableResult.add(s.getBody());
        }

        return tableResult;
    }
}
