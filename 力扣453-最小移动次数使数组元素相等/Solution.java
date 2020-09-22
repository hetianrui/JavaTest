class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max){
                max=nums[i];
            }
        }
        int res=0;
        for(int i=0;i<nums.length;i++){
            res=res+(nums[i]-max);
        }
        return res;
    }
}