public class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int count=0;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
            count=l;
        }
        return nums[count];
    }
}