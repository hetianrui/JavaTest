package TestCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertNum {
    public static int searchInsert(int[] nums, int target) {
        List<Integer> list=new ArrayList<Integer>();
        int k=nums.length+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
              k=i;
            }

        }
        if(k!=nums.length+1){
            return k;
        }else {
            int temp=0;
            list.add(target);
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            Collections.sort(list);
            for (int i=0;i<list.size();i++){
                if (list.get(i)==target){
                    temp=i;
                }
            }
            return temp;
        }

    }
    /*
     for(int i = 0; i < nums.length;i++){
        if(nums[i] >= target){
            return i;
        }
    }
    return nums.length;  //最简代码
     */

}
