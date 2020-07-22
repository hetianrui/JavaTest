public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int a=0,b=m-1;
        while((a>=0 && a<n) && (b>=0 && b<m)){
            if(matrix[a][b]==target){
                return true;
            }
            if(matrix[a][b]>target){
                b--;
            }else{
                a++;
            }
        }
        return false;
    }
}