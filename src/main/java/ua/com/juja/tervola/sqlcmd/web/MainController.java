package ua.com.juja.tervola.sqlcmd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.juja.tervola.sqlcmd.service.Menu;
import ua.com.juja.tervola.sqlcmd.service.MessageText;
import ua.com.juja.tervola.sqlcmd.service.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by user on 12/17/2015.
 */
@Controller
public class MainController {

    @Autowired
    private Menu menu;

    @Autowired
    private Service service;

    @Autowired
    MessageText messageText;

    private String sqlCommand;


    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String connect(Model model) {

        model.addAttribute("connection", new Connection());
        return "connect";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connecting(@ModelAttribute("connection") Connection connection, Model model)  {

        try {
            service.connect(connection.getDatabase(), connection.getUserName(), connection.getPassword());
            service.setConnectedStatus(true);
            return "redirect:/menu";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
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
    public String menu(Model model) {
        model.addAttribute("status", service.isConnected() ? "connected!" : "not connected!");
        model.addAttribute("dbname", service.getConfigReader().getDatabaseName());
        model.addAttribute("username", service.getConfigReader().getUserName());

        if (service.isConnected()) {
            model.addAttribute("items", menu.commandsList());
        } else {
            model.addAttribute("items", menu.connectionCommandsList());
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
    public String mockConnecting(Model model) {
        try {
            service.connect2();
            service.setConnectedStatus(true);
            model.addAttribute("status", service.isConnected() ? "connected!" : "not connected!");
            return "redirect:/menu";
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws SQLException {
        model.addAttribute("tablelist", service.tableList());
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
    public String selectingResult(Model model) {

        try {
            model.addAttribute("select", service.select(sqlCommand));
        } catch (SQLException e) {
            model.addAttribute("message", e.getMessage());
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
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/execute_result", method = RequestMethod.GET)
    public String executeResult(Model model) {

        try {
            service.executeCommand(sqlCommand);
            model.addAttribute("execute", sqlCommand);
            model.addAttribute("result", "successfully");
        } catch (SQLException e) {
            model.addAttribute("result", "FAIL");
            model.addAttribute("error", e.getMessage());
        }
        return "execute_result";
    }

    @RequestMapping(value = "/execute_mock", method = RequestMethod.GET)
    public String executeMock() {
        return "execute_mock";
    }

    @RequestMapping(value = "/execute_mock", method = RequestMethod.POST)
    public String executingMock() {

        sqlCommand = messageText.getCommandExecuteMock();

        return "redirect:/execute_result";
    }
}
