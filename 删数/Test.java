import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int arr[] = new int[scanner.nextInt()];
            method(arr);
        }
    }
    public static void method(int[] arr){
        int a=arr.length;
        if(a>=1000){
            a=999;
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < a; i++) {
            list.add(i);
        }
        int i=0;
        while (list.size()>1){
            i=(i+2)%list.size();
            list.remove(i);
        }
        System.out.println(list.get(0));
    }

}

