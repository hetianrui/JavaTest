import java.util.Scanner;

public class Number1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNextLine()){
         String a=scanner.nextLine();
         String s[]=a.split(" ");
         int i=Integer.parseInt(s[0]);
         int i1=Integer.parseInt(s[1]);
         int i2=Integer.parseInt(s[2]);
         int i3=Integer.parseInt(s[3]);
          Number1.Nummer(i,i1,i2,i3);
        }
    }
    public static void Nummer(int a,int b,int c,int d){
        int e=(a+c)/2;
        int f=(b+d)/2;
        int g=(b-d)/-2;
       if(((e-f)==a)&&((f-g)==b)&&((e+f)==c)&&((f+g)==d)){
           System.out.println(e+" "+f+" "+g);
       }else {
           System.out.println("No");
       }
    }
}
