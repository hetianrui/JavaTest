import java.util.Scanner;

public class Applen {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            System.out.println(Number(n));
        }
    }
    public static int Number(int n){
        if(n%2!=0){
            return -1;
        }
        if(n%8==0){
            return n/8;
        }
        if(n%8!=0){
            return n/8+1;
        }
        return n;
    }
}
