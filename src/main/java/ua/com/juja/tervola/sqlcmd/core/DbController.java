package ua.com.juja.tervola.sqlcmd.core;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 9/1/2015.
 */
public interface DbController {

    ArrayList<String> tableList() throws SQLException;

    ArrayList<String[]> select(String sql) throws SQLException;

    void executeCommand(String sql) throws SQLException;

    boolean isExistLogTable() throws SQLException;

}
