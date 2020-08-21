package Scan;

public class Test implements Runnable {

    public static int count = 100;
    public static Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object) {
                object.notify();
                if(count<0){
                    break;
                }
                    System.out.println(count--);
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       }
    }

    public static void main(String[] args) {
        Test s=new Test();
        Thread thread=new Thread(s);
        Thread thread1=new Thread(s);
        thread.start();
        thread1.start();

    }
}
