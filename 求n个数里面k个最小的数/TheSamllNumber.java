package TestCode;

import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.Scanner;

public class TheSamllNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            String str1[]=str.split(" ");
            int arr[]=new int[str1.length];

            int n=Integer.parseInt(str1[str1.length-1]);
          for(int i=0;i<str1.length;i++){
              arr[i]=Integer.parseInt(str1[i]);
          }
          int arr1[]=new int[arr.length-1];
          for(int i=0;i<arr1.length;i++){
              arr1[i]=arr[i];
          }
            Arrays.sort(arr1);
          for(int i=0;i<n-1;i++){
              System.out.print(arr1[i]+" ");
          }
            System.out.print(arr1[n-1]);



        }
    }
    }

