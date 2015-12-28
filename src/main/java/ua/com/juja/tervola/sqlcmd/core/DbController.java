package ua.com.juja.tervola.sqlcmd.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 9/1/2015.
 */
public interface DbController {

    // TODO: Impl logic how to create check log table
    boolean checkTable(String tableName) throws SQLException;

    List<String> tableList() throws SQLException;

    ArrayList<String[]> select(String sql) throws SQLException;

    void executeCommand(String sql) throws SQLException;

    void truncateTable(String tableName) throws SQLException;

}
