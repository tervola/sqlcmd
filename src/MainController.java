import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 9/1/2015.
 */
public interface MainController {

    Connection connect();

    String tableList(Connection connection) throws SQLException;

    ArrayList<String[]> select(Connection connection, String sql) throws SQLException;

    void executeCommand(Connection connection, String sql) throws SQLException;

    void close(Connection connection) throws SQLException;

}
