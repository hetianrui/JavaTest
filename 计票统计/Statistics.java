package TestCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
           int a=scanner.nextInt();
           String b[]=new String[a];
           for(int i=0;i<a;i++){
               b[i]=scanner.next();
           }
            Map<String,Integer> map=new HashMap<>();
           for (int i=0;i<a;i++){
               map.put(b[i],0);
           }
            int a1=scanner.nextInt();
           String str[]=new String[a1];
           for (int i=0;i<a1;i++){
            str[i]=scanner.next();
           }

           for(int i=0;i<a1;i++){
               for (Map.Entry<String,Integer> e:map.entrySet()) {
                   String s1=e.getKey();
                   int s2=e.getValue();
                   if(str[i].equals(e.getKey())){
                       map.put(s1,s2+1);
                   }
               }
           }


           int Invalid=0;
           for(Map.Entry<String,Integer> e:map.entrySet()){
               Invalid+=e.getValue();
           }
           for (int i=0;i<b.length;i++){
               for (Map.Entry<String,Integer> e:map.entrySet()){
                   if(b[i].equals(e.getKey())){
                       System.out.println(e.getKey()+" "+":"+" "+e.getValue());
                   }
               }
           }
            System.out.println("Invalid"+" "+":"+" "+(a1-Invalid));

        }
    }
}
