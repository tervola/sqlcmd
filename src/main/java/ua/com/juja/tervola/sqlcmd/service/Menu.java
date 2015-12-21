package ua.com.juja.tervola.sqlcmd.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 12/21/2015.
 */
@Component
public class Menu {

    public List<String> commandsList() {
        return Arrays.asList("help", "list", "select", "select_mock", "execute", "execute_mock", "disconnect");
    }

    public List<String> connectionCommandsList() {
        return Arrays.asList("help", "connect", "mock");
    }
}
