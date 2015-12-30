package ua.com.juja.tervola.sqlcmd.service;

import org.springframework.stereotype.Component;

/**
 * Created by user on 12/7/2015.
 */
@Component
public class MessageText {
    public String getTextMockConnections() {
        return "* Use MOCK option for automatic connect to DB";
    }

    public String getTextLogsEnablind() {
        return "enabling logs";
    }

    public String getTextLogsClean() {
        return "clean logs";
    }

    public String getCommandExecuteMock() {
        return "INSERT INTO id VALUES (222, \'mock\', \'mock\')";
    }

    public String getCommandSelectMock() {
        return "select * from id";
    }
}
