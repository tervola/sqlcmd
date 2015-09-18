import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 9/1/2015.
 */
public interface MainController {

    String tableList() throws SQLException;

    ArrayList<String[]> select(String sql) throws SQLException;

    void executeCommand(String sql) throws SQLException;

    void close() throws SQLException;

}
