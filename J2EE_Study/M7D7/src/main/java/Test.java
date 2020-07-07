import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("a.xml");
        Object o=context.getBean("myName");
        System.out.println(o.getClass());
        System.out.println(o);
        Object o1=context.getBean("myName");
        System.out.println(o1.getClass());
        System.out.println(o1);
        System.out.println(o==o1);
    }
}
