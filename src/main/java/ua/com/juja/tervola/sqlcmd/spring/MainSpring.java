package ua.com.juja.tervola.sqlcmd.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by user on 11/20/2015.
 */
public class MainSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"prop/application-context.xml"});
        MyBean myBean = (MyBean) context.getBean("rat");
        myBean.sayHi();
        myBean.setText("Zdraste!");
        System.out.println(myBean.getName());
        System.out.println(myBean.getText());
        System.out.println("---");
//        System.out.println(myBean.get);
    }
}
