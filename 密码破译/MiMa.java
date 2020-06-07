package TestCode;


import java.util.Scanner;

public class MiMa {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            char[] ch=s.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(String.valueOf(ch[i]).equals(" ")){
                    continue;
                }
                if(ch[i]>69){
                    ch[i]-=5;
                }else {
                    ch[i]+=21;
                }
            }
            System.out.println(ch);
        }
    }
}
