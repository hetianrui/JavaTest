import java.util.ArrayList;
import java.util.List;

public class solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> list = new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++){
           list.add(new ArrayList<>(i + 1));
        }
        List<Integer> list1 = new ArrayList<>();

        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i=2;i<numRows;i++){
            List<Integer> nums=list.get(i);
            nums.add(1);
            for(int j=1;j<i;j++){
                int num=list.get(i-1).get(j-1)+list.get(i-1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
     return list;}
     }
