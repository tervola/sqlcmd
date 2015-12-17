package ua.com.juja.tervola.sqlcmd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.juja.tervola.sqlcmd.service.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by user on 12/17/2015.
 */
@Controller
public class MainController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help() {
        return "help";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(HttpServletRequest request) {
        request.setAttribute("items", service.commandsList());
        return "menu";
    }
}
