package TestCode;


import java.util.Scanner;
import java.math.BigInteger;
public class NjieChen {
    public BigInteger Number(BigInteger x) {
        if (x.equals(BigInteger.valueOf(1))) {
            return BigInteger.valueOf(1);
        } else {
            return x.multiply(Number(x.subtract(BigInteger.valueOf(1))));

        }
    }

    public static void main(String[] args) {
        NjieChen n = new NjieChen();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int c = scanner.nextInt();
            BigInteger v = new BigInteger(String.valueOf(BigInteger.valueOf(c)));
            BigInteger c1 = n.Number(v);
             int count=0;
            BigInteger x=BigInteger.valueOf(10);
                while (true){

                    if (!((c1.remainder(x)).equals(BigInteger.valueOf(0)))) {
                        System.out.println(count);
                        break;
                    }
                    x=x.multiply(BigInteger.valueOf(10));
                    count++;
                }


            }

        }
    }

