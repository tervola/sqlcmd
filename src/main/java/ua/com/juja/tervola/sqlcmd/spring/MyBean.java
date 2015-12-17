package ua.com.juja.tervola.sqlcmd.spring;

/**
 * Created by user on 11/20/2015.
 */
public class MyBean {
    private String text;
    private String name;

    private Service service;


    public void setService(Service service) {
        this.service = service;
    }

    public MyBean(String text) {
    this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHi() {
        System.out.println(text + service.getData());
    }

}
