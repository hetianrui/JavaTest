import sun.plugin.com.event.COMEventHandler;

public class Demo {
    public static void main(String[] args) {

        Computer computer=new Computer();
        computer.turnon();
        computer.use(new Mouse());
        computer.use(new Keyboard());
        computer.turnoff();
    }
}
