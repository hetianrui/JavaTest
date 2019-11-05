import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        System.out.println(HuiWen.HuiWenNumber(a,b));


    }

    private static int HuiWenNumber(String a,String b){
        int count=0;
        for(int i=0;i<=a.length();i++){
            StringBuffer s=new StringBuffer(a);
            StringBuffer s2=new StringBuffer(s.insert(i,b));
            StringBuffer s1=new StringBuffer(s.reverse());
            if(s2.toString().equals(s1.toString())){
                count++;
            }
        }
        return count;
}
}
