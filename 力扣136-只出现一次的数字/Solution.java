package htr.mapper;

public class Solution {
    public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        // int count=0;
        // if(nums.length==1){
        //     return nums[0];
        // }
        // if(nums[0]!=nums[1]){
        //     return nums[0];
        // }
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]!=nums[i-1] && nums[i]!=nums[(i+1)%nums.length]){
        //         count=nums[i];
        //         break;
        //     }
        // }
        // return count;
        int count=0;
        for(int i=0;i<nums.length;i++){
            count=count^nums[i];
        }
        return count;
    }
}
