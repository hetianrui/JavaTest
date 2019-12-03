package TestCode;

import java.util.Scanner;

public class yiGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int begin=scanner.nextInt();
            int ghost[]=new int[num];
            for(int i=0;i< ghost.length;i++){
                ghost[i]=scanner.nextInt();
            }
            for (int i=0;i<ghost.length;i++){
                if(ghost[i]<=begin){
                    begin+=ghost[i];
                }else {
                    int tem=0;
                    for (int j=begin;j>=1;j--){
                        if( begin%j==0 && ghost[i]%j==0 ){
                            begin+=j;
                            break;
                        }
                    }
                }
            }
            System.out.println(begin);
        }
    }
}
