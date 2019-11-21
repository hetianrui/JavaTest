package TestCode;

import java.util.Scanner;

public class AoBaMa {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str=scanner.nextLine();
            String str1[]=str.split(" ");
            int x=Integer.parseInt(str1[0]);

            double y=Math.ceil(x/2.0);
            System.out.println(y);
            for(int i=0;i<x;i++){
                System.out.print(str1[1]);

            }
            System.out.println();
            for(int i=0;i<(y-2);i++){
                for(int j=0;j<x;j++){
                    if(j==0||j==(x-1)){
                        System.out.print(str1[1]);
                    }else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            for(int i=0;i<x;i++){
                System.out.print(str1[1]);
            }
            System.out.println();
        }
    }
}
