import java.util.Scanner;

public class FindX {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b[] = new int[a];
            for (int i = 0; i < b.length; i++) {
                b[i] = scanner.nextInt();
            }
            int c = scanner.nextInt();
            int d = 0,e=0;
            for (int i = 0; i < b.length; i++) {
                if (c == b[i]) {
                    d=i;
                    e++;
                }
            }
            if(e==1){
                System.out.println(d);
            }else {
                System.out.println(-1);
            }
        }

    }
}
