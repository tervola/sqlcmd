package ua.com.juja.tervola.sqlcmd.model;

import java.util.List;

/**
 * Created by user on 1/26/2016.
 */
public interface UserActionsDao {
    void log(String username, String dbname, String action);
    List<UserAction> getAllFor(String userName);
}
