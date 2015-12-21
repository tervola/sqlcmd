package ua.com.juja.tervola.sqlcmd.web;

/**
 * Created by user on 12/21/2015.
 */
public class Connection {
    private String userName;
    private String password;
    private String database;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
