package TestCode;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

import java.util.Scanner;

public class NiKeCheSi {
    public static String GetNum(int m){
        int n=m*m-m+1;
        if(m==1){
            System.out.println(1);
        }else {
            for (int i=0;i<m;i++){
                if(i==(m-1)){
                    System.out.print(n);
                }else {
                    System.out.print(n+"+");
                }
                n+=2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNextInt()){
            int a=scanner.nextInt();
            GetNum(a);
            System.out.println();
        }

    }
}
