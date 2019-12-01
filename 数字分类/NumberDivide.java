package TestCode;



import java.text.DecimalFormat;

import java.util.Scanner;

public class NumberDivide {
    public static String  a(int a[]){
        int count=0;
        String s="N";
        for(int i=0;i<a.length;i++){
            if( a[i]%5==0 && a[i]%2==0 ){
               count+=a[i];
            }
        }
        if(count==0){
            return s;
        }else
            return String.valueOf(count);
    }
    public static String b(int a[]){
        double count=0;
        String s="N";
        int c=0;
        for (int i=0;i<a.length;i++){
            if(a[i]%5==1){
                count=count+a[i]*Math.pow(-1,c);
                c++;
            }
        }
        if(count==0){
            return s;
        }else{
            int i=(int) count;
            return String.valueOf(i);
        }


    }
    public static String c(int a[]){
        int count=0;
        String s="N";
        for(int i=0;i<a.length;i++){
            if(a[i]%5==2){
                count++;
            }
        }
        if(count==0){
            return s;
        }else
            return String.valueOf(count);
    }
    public static String d(int a[]){
        int count=0;
        String s="N";
        double c=0.0;

       for (int i=0;i<a.length;i++){
           if(a[i]%5==3){
               count+=a[i];
               c++;
           }
       }
       if(count==0){
           return s;
       }else {
           DecimalFormat decimalFormat=new DecimalFormat("###.0");
           return decimalFormat.format(count/c);
       }
    }
    public static String e(int a[]){
        int count=0;
        String s="N";
        for(int i=0;i<a.length;i++){
            if(a[i]%5==4 && a[i]>count){
                count=a[i];
            }
        }
        if(count==0){
            return s;
        }else
            return String.valueOf(count);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int a=scanner.nextInt();
            int b[]=new int[a];
            for (int i=0;i<b.length;i++){
                b[i]=scanner.nextInt();
            }
            System.out.println(a(b)+" "+b(b)+" "+c(b)+" "+d(b)+" "+e(b));

        }


    }
}
