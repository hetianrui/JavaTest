

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int count=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                count=i;
                return count;
            }
        }
        return count;

    }
}
