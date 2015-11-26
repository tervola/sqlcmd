package ua.com.juja.tervola.sqlcmd.web;

import ua.com.juja.tervola.sqlcmd.service.Service;
import ua.com.juja.tervola.sqlcmd.service.ServiceImpl;

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
    Service service;
    String sqlCommand;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            service = new ServiceImpl();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = getAction(req);
        if (service.isConnected()) {
            req.setAttribute("items", service.commandsList());
            if (service.isLoggingEnabled()){
                req.setAttribute("logs", "enabling logs");
            } else {
                req.setAttribute("logs", "clean logs");
            }
        } else {
            req.setAttribute("items", service.connectionCommandsList());
        }

        if (action.equals("/menu")) {

            req.setAttribute("status", service.isConnected() ? "connected!" : "not connected!");
            req.setAttribute("dbname", service.getConfigReader().getDatabaseName());
            req.setAttribute("username", service.getConfigReader().getUserName());
            req.getRequestDispatcher("menu.jsp").forward(req, resp);

        } else if (action.equals("/help")) {

            req.getRequestDispatcher("help.jsp").forward(req, resp);

        } else if (action.equals("/connect")) {

            req.getRequestDispatcher("connect.jsp").forward(req, resp);

        }else if (action.equals("/log_clean")) {

            req.getRequestDispatcher("log_clean.jsp").forward(req, resp);

        } else if (action.equals("/mock")) {

            req.getRequestDispatcher("mock.jsp").forward(req, resp);

        } else if (action.equals("/select")) {

            req.getRequestDispatcher("select.jsp").forward(req, resp);
        } else if (action.equals("/select_mock")) {
            req.getRequestDispatcher("select_mock.jsp").forward(req, resp);
        } else if (action.equals("/execute")) {
            req.getRequestDispatcher("execute.jsp").forward(req, resp);
        } else if (action.equals("/execute_result")) {
            try {
                service.executeCommand(sqlCommand);
                req.setAttribute("execute", sqlCommand);
            } catch (SQLException e) {
                redirectToErrorPage(req, resp, e);
            }
            req.getRequestDispatcher("execute_result.jsp").forward(req, resp);
        } else if (action.equals("/select_result")) {
            try {
                req.setAttribute("select", service.select(sqlCommand));
            } catch (SQLException e) {
                redirectToErrorPage(req, resp, e);
            }
            req.getRequestDispatcher("select_result.jsp").forward(req, resp);
        } else if (action.equals("/list")) {
            try {
                req.setAttribute("tablelist", service.tableList());
            } catch (SQLException e) {
                redirectToErrorPage(req, resp, e);
            }
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

    }

    private void redirectToErrorPage(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        e.printStackTrace();
        req.setAttribute("error", e.getMessage());
        req.getRequestDispatcher("error.jsp").forward(req, resp);
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
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }

        } else if (action.equals("/select")) {

            sqlCommand = req.getParameter("command");
            resp.sendRedirect(resp.encodeRedirectURL("select_result"));

        } else if (action.equals("/execute")) {

            sqlCommand = req.getParameter("command");
            resp.sendRedirect(resp.encodeRedirectURL("execute_result"));

        } else if (action.equals("/select_mock")) {

            sqlCommand = "select * from employee";
            resp.sendRedirect(resp.encodeRedirectURL("select_result"));

        } else if (action.equals("/logs")) {

            try {
                service.enablingLog(true);
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (Exception e) {
                redirectToErrorPage(req,resp,e);
            }

        }else if (action.equals("/mock")) {

            try {
                service.connect2();
                service.setConnectedStatus(true);
                req.setAttribute("status", service.isConnected() ? "connected!" : "not connected!");
                resp.sendRedirect(resp.encodeRedirectURL("menu"));
            } catch (Exception e) {
                try {
                    throw new SQLException(Arrays.toString(e.getStackTrace()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                req.setAttribute("message", e.getMessage());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
    }
}
