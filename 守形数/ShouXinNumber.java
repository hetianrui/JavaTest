package TestCode;

import java.util.Scanner;

public class ShouXinNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int a=scanner.nextInt();
            int b=a*a;
            String c=String.valueOf(a);
            String d=String.valueOf(b);
            if(a==10){
                System.out.println("No!");
                break;
            }
            if(d.contains(c)){
                System.out.println("Yes!");
            }else
                System.out.println("No!");
        }
    }
}
