package TestCode;

public class Solution {
    public int[] multiply(int[] A) {
         int b=A.length;
         int B[]=new int[b];


         for(int i=0;i<b;i++){
             int temp=A[i];
             A[i]=1;
             B[i]=1;
             for(int j=0;j<b;j++){
                 B[i]=B[i]*A[j];
             }
             A[i]=temp;
         }
         return B;
    }
}
