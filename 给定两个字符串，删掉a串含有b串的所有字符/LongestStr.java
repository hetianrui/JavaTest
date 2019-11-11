import java.util.Scanner;

public class  LongestStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        StringBuffer c=new StringBuffer();

        for(int i=0;i<a.length();i++){
            int count=0;
            String d= String.valueOf(a.charAt(i));
            for(int j=0;j<b.length();j++){
                String e= String.valueOf(b.charAt(j));
                if(!d.equals(e)){
                    count++;
                }
            }
            if(count==b.length()){
                c.append(a.charAt(i));
            }
        }

        System.out.println(c);

    }
    }
}


