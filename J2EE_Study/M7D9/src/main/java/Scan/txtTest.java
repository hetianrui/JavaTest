package Scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class txtTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("Scan");

        Object test = context.getBean("test");
        System.out.println(test.getClass());
        System.out.println(test);
    }
}
