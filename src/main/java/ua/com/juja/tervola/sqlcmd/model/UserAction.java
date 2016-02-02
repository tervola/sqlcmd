package ua.com.juja.tervola.sqlcmd.model;

/**
 * Created by user on 1/26/2016.
 */
public final class UserAction {
    private String username;
    private String dbname;
    private String action;
    private int id;

    public UserAction(String username, String dbname, String action) {
        this.username = username;
        this.dbname = dbname;
        this.action = action;
    }

    public UserAction() {

    }

    public String getUsername() {
        return username;
    }

    public String getDbname() {
        return dbname;
    }

    public String getAction() {
        return action;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setId(int id) {
        this.id = id;
    }
}
