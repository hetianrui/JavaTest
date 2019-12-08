package TestCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JiJianYan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);



        while(scanner.hasNext()){
            int a=scanner.nextInt();
            BigInteger b[]=new BigInteger[a];
            for (int i=0;i<a;i++){
                b[i]=scanner.nextBigInteger();

            }
            List<BigInteger> list=new ArrayList<>();
            for (int i=0;i<a;i++){
                list.add(b[i]);

            }
            Collections.sort(list);
            BigInteger c[]=new BigInteger[a];
            for (int i=0;i<a;i++){
                c[i]=list.get(i);

            }
            for (int i=0;i<a;i++){
                System.out.println(c[i]);

            }

        }



        }
}
