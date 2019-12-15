package TestCode;

import java.util.Scanner;

public class BuyorNot {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNext()){
            String a=scanner.next();
            int num=a.length();
            String b=scanner.next();
            String bcopy=b;
            char[] a1=a.toCharArray();
            char[] b1=b.toCharArray();
            StringBuilder str=new StringBuilder();
            for(int i=0;i<b.length();i++){
                for(int j=0;j<a1.length;j++){
                    if(String.valueOf(b1[i]).equals(String.valueOf(a1[j]))){
                        str.append(a1[j]);
                        if(j==a.length()){
                            a=a.substring(0,j);
                        }else {
                            a=a.substring(0,j)+a.substring(j+1);
                        }

                        b=b.substring(0,i)+b.substring(i+1);
                        b1=b.toCharArray();
                        i=0;

                    }
                    if(b.equals("")){
                        break;
                    }

                }

                a1=a.toCharArray();

            }

            if(new String(str).equals(bcopy)){
                System.out.println("Yes"+" "+(num-bcopy.length()));
            }else {
                System.out.println("No"+" "+(b.length()));
            }

        }
    }
}
