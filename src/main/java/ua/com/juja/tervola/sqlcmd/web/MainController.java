package ua.com.juja.tervola.sqlcmd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.juja.tervola.sqlcmd.core.DbController;
import ua.com.juja.tervola.sqlcmd.service.MessageText;
import ua.com.juja.tervola.sqlcmd.service.Service;

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
        if(service.isConnected()) {
            request.setAttribute("items", service.commandsList());
        } else {
            request.setAttribute("items", service.connectionCommandsList());
        }
        return "menu";
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
}
