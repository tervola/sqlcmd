package ua.com.juja.tervola.sqlcmd.spring;

import ua.com.juja.tervola.sqlcmd.service.*;

/**
 * Created by user on 11/20/2015.
 */
public class HelloWorldServiceImpl implements ua.com.juja.tervola.sqlcmd.spring.Service {

    @Override
    public String getData(){
        return " {Hello, amigo}";
    }
}
