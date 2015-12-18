package ua.com.juja.tervola.sqlcmd.springcore;


/**
 * Created by user on 11/20/2015.
 */
public class HelloWorldServiceImpl implements ua.com.juja.tervola.sqlcmd.springcore.Service {

    @Override
    public String getData() {
        return " {Hello, amigo. From HelloService!}";
    }
}
