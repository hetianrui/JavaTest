package TestCode;

import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
         while (scanner.hasNext()){
             String str=scanner.next();
             String str2=scanner.next();
             int num=Integer.parseInt(str2);
             StringBuffer all=new StringBuffer(str);
             String str1=all.toString();
             char ch[]=str1.toCharArray();
             int res=0;


          StringBuffer result=new StringBuffer();
             for(int i = 0; i<all.length()-num+1; i++){
                 StringBuffer spare=new StringBuffer();
                 int x=i;
                 int count=0;
                 for(int j=0;j<num;j++){
                     spare.append(ch[x]);
                     if(ch[x]=='C'||ch[x]=='G'){
                         count++;
                     }
                     x++;
                 }
                 if(count>res){
                     res=count;
                    result=spare;
                 }


             }
            System.out.println(result);


         }
    }
}
