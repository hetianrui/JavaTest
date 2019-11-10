import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows){
     List<List<Integer>> list=new ArrayList<>(numRows);
     for (int i=0;i<numRows;i++){
         list.add(new ArrayList<>(i+1));
     }
     list.get(0).add(1);
     list.get(1).add(1);//add是尾插
     list.get(1).add(1);
     for( int i=2;i<numRow s;i++){
         List<Integer> nums=list.get(i);
         nums.add(1);
         for (int j=1;j<i;j++){
             int num=list.get(i-1).get(j-1)
                     +list.get(i-1).get(j);
             nums.add(num);
         }
         nums.add(1);
     }
     return list;
    }
    private static void printPascalsTriangle(Solution s,int n){
        System.out.println(s.generate(n));
    }

    public static void main(String[] args) {
        Solution solution=new Solution() ;

       printPascalsTriangle(solution,5);
    }
}
