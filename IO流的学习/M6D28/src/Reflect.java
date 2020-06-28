import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class c=null;
        try {
            c = Class.forName("Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c);
//        Properties p=new Properties();
//
//        try {
//            p.load(Reflect.class.getClassLoader().getResourceAsStream("a.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(p.getProperty("user"));
//        System.out.println(p.getProperty("password"));
    }
    @Test
    public void test() throws IOException {
        Properties p=new Properties();
        p.load(new FileInputStream("a1.properties"));
        System.out.println(p.getProperty("user"));
        System.out.println(p.getProperty("password"));
    }
}
class Person {
        int id;
        String name;
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}