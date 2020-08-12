class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]={-1,-1};
        if (nums.length == 0) {
            return res;
        }
        int i = 0;
        int count = 0;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        boolean flag = false;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target == nums[mid]) {
                i=mid+1;
                while(i<nums.length && nums[i]==target){
                    i++;
                }
                res[1]=i-1;
                i=mid-1;
                while(i>=0 && nums[i]==target){
                    i--;
                }
                res[0]=i+1;
                return res;
            }
        }
        return res;
    }
}