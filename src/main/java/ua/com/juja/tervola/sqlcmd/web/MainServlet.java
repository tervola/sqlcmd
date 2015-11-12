package ua.com.juja.tervola.sqlcmd.web;

import ua.com.juja.tervola.sqlcmd.service.Service;
import ua.com.juja.tervola.sqlcmd.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by user on 11/6/2015.
 */
public class MainServlet extends HttpServlet {
    Service service;

    @Override
    public void init() throws ServletException {
        //super.init();
//        try {
//            //service = new ServiceImpl();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = null;
        try {
            service = new ServiceImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String action = getAction(req);
        req.setAttribute("items",service.commandsList());

        if (action.equals("/menu")) {
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } else if (action.equals("/help")){
            req.getRequestDispatcher("help.jsp").forward(req, resp);
        }else if (action.equals("/connect")){
            req.getRequestDispatcher("connect.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return requestURI.substring(req.getContextPath().length(), requestURI.length());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if (action.startsWith("/connect")){
            String dbName = (String) req.getAttribute("dbname");
            String userName = (String) req.getAttribute("dbname");
            String password = (String) req.getAttribute("dbname");
            service.connect(dbName,userName,password);
           resp.sendRedirect(resp.encodeRedirectURL("menu"));
        }
    }
}
