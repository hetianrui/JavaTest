import java.util.*;

public class Number {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str="";
        while (scanner.hasNextLine()){
            str=scanner.nextLine();
            String s[]=str.split(" ");
            String s1[]=s;
            
            for(int i=0;i<s.length;i++){
                int count=0;
                for(int j=0;j<s1.length;j++){
                    if(s[i].equals(s1[j])){
                        count++;
                    }
                }
                if(count>=(s.length/2)){
                    System.out.println(s[i]);
                    break;
                }
            }



        }





    }
}
