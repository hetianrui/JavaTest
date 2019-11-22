package TestCode;

import java.math.BigInteger;
import java.util.Scanner;

public class Number {
    public static int Add(int A,int B){
        BigInteger a=BigInteger.valueOf(A);
        BigInteger b=BigInteger.valueOf(B);
        BigInteger c=a.add(b);
        int d=c.intValue();
        return d;
    }




}
