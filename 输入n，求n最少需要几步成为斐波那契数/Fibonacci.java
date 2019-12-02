package TestCode;

import java.math.BigInteger;
import java.util.*;

public class Fibonacci {
    public static BigInteger Nummer(BigInteger x){
        if(x.equals(BigInteger.valueOf(0))){
            return BigInteger.valueOf(0);
        }
        if(x.equals(BigInteger.valueOf(1))){
            return BigInteger.valueOf(1);
        }else {
            return Nummer(x.subtract(BigInteger.valueOf(1))).add(Nummer(x.subtract(BigInteger.valueOf(2))));
        }
    }
    public static void main(String[] args) {
        List<BigInteger> list=new ArrayList<>();
        for (int i=0;i<32;i++){
            list.add(Nummer(BigInteger.valueOf(i)));

        }

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextBigInteger()){

            BigInteger s=scanner.nextBigInteger();
            if(list.contains(s)){
                System.out.println(0);
                continue;
            }
            BigInteger s1=s;
            BigInteger s2=s;
            int count=0;
            int count1=0;
            do{
                count++;
                s1=s1.subtract(BigInteger.valueOf(1));
            }while (!list.contains(s1));

            do{
                count1++;
                s2=s2.add(BigInteger.valueOf(1));
            }while (!list.contains(s2));
            if(count>count1){
                System.out.println(count1);
            }else {
                System.out.println(count);
            }
        }

    }
}
