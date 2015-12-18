package ua.com.juja.tervola.sqlcmd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.juja.tervola.sqlcmd.core.DbController;
import ua.com.juja.tervola.sqlcmd.service.MessageText;
import ua.com.juja.tervola.sqlcmd.service.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by user on 12/17/2015.
 */
@Controller
public class MainController {

    @Autowired
    private Service service;

    @Autowired
    MessageText messageText;

    private String sqlCommand;


    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String connect() {
        return "connect";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connecting(HttpServletRequest request) {
        String dbName = request.getParameter("dbname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            service.connect(dbName, userName, password);
            service.setConnectedStatus(true);
            return "redirect:/menu";
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/menu";
    }


    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help() {
        return "help";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(HttpServletRequest request) {
        request.setAttribute("status", service.isConnected() ? "connected!" : "not connected!");
        request.setAttribute("dbname", service.getConfigReader().getDatabaseName());
        request.setAttribute("username", service.getConfigReader().getUserName());

        if(service.isConnected()) {
            request.setAttribute("items", service.commandsList());
        } else {
            request.setAttribute("items", service.connectionCommandsList());
        }
        return "menu";
    }

    @RequestMapping(value = "/disconnect", method = RequestMethod.GET)
    public String disconnect() throws SQLException {
        service.closeConnection();
        service.setConnectedStatus(false);
        return "redirect:/menu";
    }

    @RequestMapping(value = "/mock", method = RequestMethod.GET)
    public String mock() {
        return "mock";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/mock", method = RequestMethod.POST)
    public String mockConnecting(HttpServletRequest request) {
        try {
            service.connect2();
            service.setConnectedStatus(true);
            request.setAttribute("status", service.isConnected() ? "connected!" : "not connected!");
            return "redirect:/menu";
        } catch (SQLException e) {
            request.setAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request) throws SQLException {
        request.setAttribute("tablelist", service.tableList());
        return "list";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select() {
        return "select";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String selecting(HttpServletRequest request) {

        sqlCommand = request.getParameter("command");
        return "redirect:/select_result";
    }

    @RequestMapping(value = "/select_result", method = RequestMethod.GET)
    public String selectingResult(HttpServletRequest request) {

        try {
            request.setAttribute("select", service.select(sqlCommand));
        } catch (SQLException e) {
            request.setAttribute("message", e.getMessage());
            return "error";
        }
        return "select_result";
    }

    @RequestMapping(value = "/select_mock", method = RequestMethod.GET)
    public String selectMock() {
        return "select_mock";
    }

    @RequestMapping(value = "/select_mock", method = RequestMethod.POST)
    public String selectingMock() {
        sqlCommand = messageText.getCommandSelectMock();
        return "redirect:/select_result";
    }

    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public String execute(HttpServletRequest request) {
        sqlCommand = request.getParameter("command");
        return "execute";

    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public String executing(HttpServletRequest request) {

        sqlCommand = request.getParameter("command");
        try {
            return "redirect:/execute_result";
        } catch (Exception e)
        {
            request.setAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/execute_result", method = RequestMethod.GET)
    public String executeResult(HttpServletRequest request) {

        try {
            service.executeCommand(sqlCommand);
            request.setAttribute("execute", sqlCommand);
            request.setAttribute("result", "successfully");
        } catch (SQLException e) {
            request.setAttribute("result", "FAIL");
            request.setAttribute("error", e.getMessage());
        }
        return "execute_result";
    }

    @RequestMapping(value = "/execute_mock", method = RequestMethod.GET)
    public String executeMock() {
        return "execute_mock";
    }

    @RequestMapping(value = "/execute_mock", method = RequestMethod.POST)
    public String executingMock(HttpServletRequest request) {

        sqlCommand = messageText.getCommandExecuteMock();

        return "redirect:/execute_result";
    }
}
