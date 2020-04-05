package TestCode;

import java.util.Scanner;

public class ArrayQueue {
    int maxsize;//表示数组最大容量，所以maxsize-1表示队列满了,
                // 队列中有效元素的个数为(rear+maxsize-front)%maxsize
    int front;//队头
    int rear;//队尾的后一个位置，预留一个空位
    int arr[];//数组模拟的队列
    public static void main(String[] args) {
        ArrayQueue arr = new ArrayQueue(4);

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop == true) {
            System.out.println("e.添加元素");
            System.out.println("h.查看队头元素");
            System.out.println("g.取出队头元素");
            System.out.println("s.查看所有元素");
            System.out.println("0.退出程序");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 'e':
                    System.out.println("请输入元素");
                    String val = scanner.next();

                    arr.add(Integer.parseInt(val));
                    break;
                case 'h':
                    System.out.println(arr.head());
                    break;
                case 'g':
                    try {
                        arr.get();
                    } catch (Exception e) {
                        System.out.println("队列为空~~");
                    }
                    break;
                case 's':
                    arr.show();
                    break;
                case '0':
                    loop=false;
                    System.out.println("成功退出");
            }


        }
    }
    public  ArrayQueue(int arrmaxsize){
        maxsize=arrmaxsize;
        rear=0;
        front=0;
        arr=new int[arrmaxsize];
    }
    public  boolean isFull(){
        return (rear+1)%maxsize==front;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public void add(int val){
        if(isFull()){
            System.out.println("队列满了，无法加入");
            return;

        }
        arr[rear]=val;
        rear=(rear+1)%maxsize;
    }

    public int get() {//取出队首元素
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取出");

        }
        int val=arr[front];
        front=(front+1)%maxsize;
        return val;
    }
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i=front;i<front+number();i++){
            System.out.println("arr["+i%maxsize+"]"+"="+arr[i%maxsize]);
        }
    }
    public int head(){
        if(isEmpty()){
            System.out.println("队列空~~");
        }
        return arr[front];
    }
    public int number(){//有效元素的个数
        return (rear+maxsize-front)%maxsize;
    }
}
