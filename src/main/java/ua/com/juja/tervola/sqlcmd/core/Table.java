package ua.com.juja.tervola.sqlcmd.core;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/25/2015.
 */
public class Table {

    private List<String> title = new ArrayList<>();
    private List<String> body = new ArrayList<>();


    public void createTableResult(ResultSet resultSet) throws SQLException {
        for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
            title.add(resultSet.getMetaData().getColumnName(i+1));
        }

        for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
            body.add(resultSet.getString(i + 1));
        }
    }

    public List<String> getBody() {
        return body;
    }

    public List<String> getTitle() throws SQLException {
        return title;
    }

}
