package ua.com.juja.tervola.sqlcmd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.juja.tervola.sqlcmd.service.MessageText;
import ua.com.juja.tervola.sqlcmd.service.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by user on 11/6/2015.
 */
public class MainServlet extends HttpServlet {

    @Autowired
    Service service;
    @Autowired
    MessageText messageText;
    String sqlCommand;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = getAction(req);
        if (service.isConnected()) {
            req.setAttribute("items", service.commandsList());
            if (service.isLoggingEnabled()) {
                req.setAttribute("logs", messageText.getTextLogsEnablind());
            } else {
                req.setAttribute("logs", messageText.getTextLogsClean());
            }
        } else {
            req.setAttribute("message", messageText.getTextMockConnections());
            req.setAttribute("items", service.connectionCommandsList());
        }

        if (action.equals("/menu")) {

            req.setAttribute("status", service.isConnected() ? "connected!" : "not connected!");
            req.setAttribute("dbname", service.getConfigReader().getDatabaseName());
            req.setAttribute("username", service.getConfigReader().getUserName());

            redirectToPage(Pages.MENU, req, resp);

        } else if (action.equals("/execute_mock")) {

            redirectToPage(Pages.EXECUTE_MOCK, req, resp);

        } else if (action.equals("/help")) {

            redirectToPage(Pages.HELP, req, resp);

        } else if (action.equals("/connect")) {

            redirectToPage(Pages.CONNECT, req, resp);

        } else if (action.equals("/log_clean")) {

            redirectToPage(Pages.CLEAN_LOGS, req, resp);

        } else if (action.equals("/mock")) {

            redirectToPage(Pages.MOCK, req, resp);

        } else if (action.equals("/select")) {

            redirectToPage(Pages.SELECT, req, resp);

        } else if (action.equals("/disconnect")) {

            try {

                service.closeConnection();
                service.setConnectedStatus(false);
                req.setAttribute("items", service.connectionCommandsList());
                redirectToPage(Pages.MENU, req, resp);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equals("/select_mock")) {

            redirectToPage(Pages.SELECT_MOCK, req, resp);

        } else if (action.equals("/execute")) {

            redirectToPage(Pages.EXECUTE, req, resp);

        } else if (action.equals("/execute_result")) {

            try {
                service.executeCommand(sqlCommand);
                req.setAttribute("execute", sqlCommand);
                req.setAttribute("result", "successfully");
            } catch (SQLException e) {
                req.setAttribute("result", "FAIL");
                req.setAttribute("error", e.getMessage());
            }
            redirectToPage(Pages.EXECUTE_RESULT, req, resp);

        } else if (action.equals("/select_result")) {

            try {

                req.setAttribute("select", service.select(sqlCommand));

            } catch (SQLException e) {
                redirectToErrorPage(req, resp, e);
            }

            redirectToPage(Pages.SELECT_RESULTS, req, resp);

        } else if (action.equals("/list")) {

            try {
                req.setAttribute("tablelist", service.tableList());
            } catch (SQLException e) {
                redirectToErrorPage(req, resp, e);
            }

            redirectToPage(Pages.LIST, req, resp);

        } else {
            if (service.isConnected()) {
                redirectToPage(Pages.ERROR, req, resp);
            } else {
                redirectToPage(Pages.MENU, req, resp);
            }
        }

    }

    private void redirectToPage(Pages page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page.toString()).forward(req, resp);
    }


    private void redirectToErrorPage(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        e.printStackTrace();
        req.setAttribute("error", e.getMessage());
        redirectToPage(Pages.ERROR, req, resp);
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return requestURI.substring(req.getContextPath().length(), requestURI.length());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.equals("/connect")) {

            String dbName = req.getParameter("dbname");
            String userName = req.getParameter("username");
            String password = req.getParameter("password");

            try {
                service.connect(dbName, userName, password);
                service.setConnectedStatus(true);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (Exception e) {
                req.setAttribute("message", e.getMessage());
                redirectToPage(Pages.ERROR, req, resp);
            }

        } else if (action.equals("/execute_mock")) {

            sqlCommand = messageText.getCommandExecuteMock();
            resp.sendRedirect(resp.encodeRedirectURL("execute_result"));

        } else if (action.equals("/select")) {

            sqlCommand = req.getParameter("command");
            resp.sendRedirect(resp.encodeRedirectURL("select_result"));

        } else if (action.equals("/execute")) {

            sqlCommand = req.getParameter("command");
            try {
                resp.sendRedirect(resp.encodeRedirectURL("execute_result"));
            } catch (Exception e) {
                redirectToErrorPage(req, resp, e);
            }

        } else if (action.equals("/select_mock")) {

            sqlCommand = messageText.getCommandSelectMock();
            resp.sendRedirect(resp.encodeRedirectURL("select_result"));

        } else if (action.equals("/logs")) {

            try {
                service.enablingLog(true);
            } catch (SQLException e) {
                redirectToErrorPage(req, resp, e);
            }

            resp.sendRedirect(resp.encodeRedirectURL("menu"));

        } else if (action.equals("/mock")) {

            try {
                service.connect2();
                service.setConnectedStatus(true);
                req.setAttribute("status", service.isConnected() ? "connected!" : "not connected!");
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (SQLException e) {
                try {
                    throw new SQLException(Arrays.toString(e.getStackTrace()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                req.setAttribute("message", e.getMessage());
                redirectToPage(Pages.ERROR, req, resp);
            }
        }
    }
}
