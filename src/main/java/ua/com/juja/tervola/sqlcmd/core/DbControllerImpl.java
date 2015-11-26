package ua.com.juja.tervola.sqlcmd.core;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by user on 8/28/2015.
 */
public class DbControllerImpl implements DbController {

    Connection connection;
    boolean isExistLogTable = false;

    public DbControllerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isExistLogTable() throws SQLException {
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, "public", null, null);
        while (rs.next()) {
            if (rs.getString(3).equals("logs")){
                isExistLogTable = true;
            }
        }
        return isExistLogTable;
    }

    @Override
    public ArrayList<String> tableList() throws SQLException {
        ArrayList<String> rval = new ArrayList<String>();
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, "public", null, null);
        while (rs.next()) {
            if (rs.getString(3).equals("logs")){
                isExistLogTable = true;
            }
            rval.add(rs.getString(3));
        }
        return rval;
    }

    @Override
    public ArrayList<String[]> select(String sql) throws SQLException {

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<String[]> table = createTable(rs);
        stmt.close();

        return table;
    }

    @Override
    public void executeCommand(String sql) throws SQLException {
        doUpdateExecution(sql);
    }


    public void doUpdateExecution(String str) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(str);
        stmt.close();
    }

    private ArrayList<String[]> createTable(ResultSet resultSet) throws SQLException {
        ArrayList<String[]> list = new ArrayList<String[]>();
        int columnCount = resultSet.getMetaData().getColumnCount();
        if (columnCount < 0) return null;

        list.add(createTitle(resultSet, columnCount));

        while (resultSet.next()) {
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

        String[] rval = new String[columnCount];

        for (int i = 1; i <= columnCount; i++) {
            rval[i - 1] = resultSet.getString(i);
        }
        return rval;
    }
}
