package ua.com.juja.tervola.sqlcmd.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by user on 11/20/2015.
 */
public class MainSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"application-contex.xml"});
        MyBean myBean = (MyBean) context.getBean("rat");
        myBean.sayHi();
        myBean.setText("Zdraste!");
        myBean.sayHi();
        System.out.println(myBean.getName());
    }
}
