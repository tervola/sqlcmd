package ua.com.juja.tervola.sqlcmd.core;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 9/1/2015.
 */
public interface DbController {

    boolean checkTable(String tableName) throws SQLException;

    List<String> tableList() throws SQLException;

    List<Rows> select(String sql) throws SQLException;

    List<String> getTitle(String tableName) throws SQLException;

    void executeCommand(String sql) throws SQLException;

}
