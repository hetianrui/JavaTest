package TestCode;

import java.util.Scanner;

public class Nianhui {
    public static float fz(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }else{
            return (n-1)*(fz(n-1)+fz(n-2));
        }
    }

    public static float Jiechen(int n){
        if(n==0){
            return 1;
        }else{
            return n*Jiechen(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
             int a=scanner.nextInt();
             double a1=fz(a)/Jiechen(a)*100;
            System.out.println(String.format("%.2f",a1)+"%");
        }

    }
}
