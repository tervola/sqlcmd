package ua.com.juja.tervola.sqlcmd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 12/17/2015.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String help() {
        return "help";
    }
}
