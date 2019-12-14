package TestCode;

import java.util.Scanner;

public class CheckPassword {
    public static String Check(String a){
        String s="NG";
        String s1="OK";

        if(a.length()<8){
            return s;
        }
        char c[]=a.toCharArray();
        int low=0;
        int high=0;
        int num=0;
        int others=0;
        int res=0;
        for(int i=0;i<c.length;i++){
            if(c[i]>'a'&&c[i]<'z'){
                low=1;
            }else if(c[i]>'A'&&c[i]<'Z'){
                high=1;
            }else if(c[i]>'0'&&c[i]<'9'){
                num=1;
            }else {
                others=1;
            }
        }
        if((low+high+num+others)>=3){
            res=1;
        }
        int res1=1;
        for(int i=0;i+3<a.length();i++){
            String s2=a.substring(i,i+3);
            String s3;
            s3=a.substring(0,i)+" "+a.substring(i+3);

            if(s3.toString().contains(s2)){
                res1=0;
            }
        }
        if(res+res1==2){
            return s1;
        }else {
            return s;
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String a=scanner.next();
            System.out.println(Check(a));
        }
    }
}
