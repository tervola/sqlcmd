package ua.com.juja.tervola.sqlcmd.core;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public List<Rows> select(String sqlCommand) throws SQLException {
        List<Rows> rval;
        rval =  jdbcTemplate.query(sqlCommand,
                new RowMapper<Rows>() {

                    @Override
                    public Rows mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Rows table = new Rows();
                        table.createTableResult(rs);
                        return table;
                    }
                });

        return rval;
    }

    @Override
     public List<String> getTitle(String sqlCommand) throws SQLException {
        String tableName = null;
        Matcher matcher = Pattern.compile("select .* from ([a-z]+)").matcher(sqlCommand);
        if(matcher.find())
        {
            tableName =  matcher.group(1);
        }
        sqlCommand = String.format("SELECT column_name FROM information_schema.columns WHERE table_schema = 'public' AND table_name = '%s'", tableName);
        return  jdbcTemplate.query(sqlCommand,
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

    @Override
    public void executeCommand(String sqlCommand) throws SQLException {
        jdbcTemplate.execute(sqlCommand);
    }
}
