package TestCode;

import java.util.Scanner;

public class ArrayStack {
    public static void main(String[] args) {
        Mystack mystack=new Mystack(4);
        String s="";
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        while (loop==true){
            System.out.println("push 添加数据");
            System.out.println("pop 删除数据");
            System.out.println("show 查看有效元素");
            System.out.println("exit 退出程序");
            switch (s=scanner.nextLine()){
                case "push":
                    System.out.println("请输入数据：");
                    int key=scanner.nextInt();
                    mystack.push(key);
                    scanner.nextLine();
                    break;
                case "pop":
                    try {
                        mystack.pop();
                    } catch (Exception e) {
                        System.out.println("栈空~~");
                    }
                    break;
                case "show":
                    mystack.show();
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;

            }
        }
        System.out.println("程序退出");
    }
}
class Mystack{
    public int maxsize;
    public int top=-1;
    public int nums[];
    public  Mystack(int maxsize){
        this.maxsize=maxsize;
        this.nums=new int[maxsize];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull() {
        return top==maxsize-1;
    }

    public void push(int val){
        if(isFull()){
            System.out.println("栈满");
             return;
        }
        nums[++top]=val;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int val=nums[top--];
        return val;
    }
    public void show(){
        if(isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println("nums["+i+"]="+nums[i]);
        }
    }
}



