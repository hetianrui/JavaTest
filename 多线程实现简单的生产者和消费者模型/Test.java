
public class Test {
    public static void main(String args[]) {
       User user=new User();
       Pr pro=new Pr();
       user.start();
       pro.start();
    }
}
class User extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Protuct.class){
                if(Protuct.count==0) {
                    try {
                        Protuct.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Protuct.count>0){
                    Protuct.count--;
                    Protuct.class.notify();
                }
                System.out.println("消费者消费1还有："+Protuct.count);
            }
        }
    }
}
class Pr extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Protuct.class) {
                if (Protuct.count == 20) {
                    try {
                        Protuct.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Protuct.count < 20) {
                    Protuct.count++;
                    Protuct.class.notify();
                }
                System.out.println("生产者生产1还有：" + Protuct.count);
            }

        }
    }
}
class Protuct{
    static int count=0;
}
