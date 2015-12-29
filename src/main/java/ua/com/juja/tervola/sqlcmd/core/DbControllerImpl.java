package ua.com.juja.tervola.sqlcmd.core;

import javafx.scene.control.Tab;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 8/28/2015.
 */
public class DbControllerImpl implements DbController {

    Connection connection;
    JdbcTemplate jdbcTemplate;
    boolean isExistLogTable = false;

    public DbControllerImpl(Connection connection) {
        this.connection = connection;
        jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(connection, false));
    }

    //TODO: add tests, change logic for trancate/
    @Override
    public void truncateTable(String tableName) throws SQLException {
        String sqlCommand = String.format("TRUNCATE %s",tableName);
    }

    // TODO: Impl logic how to create check log table
    @Override
    public boolean checkTable(String tableName) throws SQLException {
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, "public", null, null);
        while (rs.next()) {
            if (rs.getString(3).equals(tableName)) {
                isExistLogTable = true;
            }
        }
        return isExistLogTable;
    }

    @Override
    public List<String> tableList() throws SQLException {
        String sqlCommand = "SELECT table_name FROM information_schema.tables WHERE table_schema=\'public\'";
        return jdbcTemplate.query(sqlCommand,
                new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                            return rs.getString(i + 1);
                        }
                        throw new SQLException();
                    }
                });
    }

    public List<Table> select(String sqlCommand) throws SQLException {
        List<Table> rval;
        rval =  jdbcTemplate.query(sqlCommand,
                new RowMapper<Table>() {

                    @Override
                    public Table mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Table table = new Table();
                        table.createTableResult(rs);
                        return table;
                    }
                });

        return rval;
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
}
