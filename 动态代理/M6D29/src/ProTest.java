import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProTest {
    public static void main(String[] args) {
        superman human= (superman) pro.getInstance(new human());
        System.out.println("4");
        human.job("超人");

    }
}
interface superman{

    void job(String name);
}
class human implements superman{
    @Override
    public void job(String name) {
        System.out.println("3");
        System.out.println(name+"正在打怪兽。");
    }
}
class pro{
    public static Object getInstance(Object o){
        System.out.println("1");
        MyInvotion handler=new MyInvotion();
        handler.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),handler);
    }
}
class MyInvotion implements InvocationHandler{
    Object obj;
    public void bind(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("2");
        return method.invoke(obj,args);
    }
}