package TestCode;

import java.util.Scanner;

public class Rabbits {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            System.out.println(Number(scanner.nextInt()));
        }
    }
    public static int Number(int a){
        if(a<3){
            return 1;
        }
        int month1=1;
        int month2=0;
        int produce=1;
        int result=1;
        for(int i=4;i<=a;i++){
          produce+=month2;
          month2=month1;
          month1=produce;
          result=month1+month2;

        }
        return result+produce;
    }
}
