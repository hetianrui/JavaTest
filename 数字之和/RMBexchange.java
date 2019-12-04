package TestCode;

import java.util.Scanner;

public class RMBexchange {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int a=scanner.nextInt();
            int b=a;
            int result=0;
           while (b!=0){
               result+=b%10;
               b=b/10;
           }
            int c=a*a;
           int result1=0;
            while (c!=0){
                result1+=c%10;
                c=c/10;
            }
            System.out.println(result+" "+result1);
        }


    }
}
