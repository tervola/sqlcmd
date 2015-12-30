package ua.com.juja.tervola.sqlcmd.core;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 9/1/2015.
 */
public interface DbController {

    // TODO: Impl logic how to create check log table
    boolean checkTable(String tableName) throws SQLException;

    List<String> tableList() throws SQLException;

    List<Rows> select(String sql) throws SQLException;

    List<String> getTitle(String tableName) throws SQLException;

    void executeCommand(String sql) throws SQLException;

    void truncateTable(String tableName) throws SQLException;

}
