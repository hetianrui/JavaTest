package TestCode;

import java.math.BigInteger;
import java.util.*;

public class Number {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextBigInteger()){
            BigInteger b=scanner.nextBigInteger();
            List<Integer> list=new ArrayList<>();
            while (true){
                BigInteger a;
                a=b.remainder(BigInteger.valueOf(10));
                list.add(a.intValue());
                b=b.divide(BigInteger.valueOf(10));
                if(b.equals(BigInteger.valueOf(0))){
                    break;
                }

            }
            Collections.sort(list);
            Map<Integer,Integer> map=new HashMap<>();
            for (int n:list){
                int c=map.getOrDefault(n,0);
                map.put(n,c+1);
            }
            for (Map.Entry<Integer,Integer> e:map.entrySet()) {
                int n = e.getKey();
                int c = e.getValue();
                System.out.println(n+":"+c);
            }

        }

    }
}
