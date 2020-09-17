class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int x=nums[(nums.length-1)>>1];
        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=(Math.abs(nums[i]-x));
        }
        return res;
    }
}