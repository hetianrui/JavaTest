public class Solution {
    public int findMin(int[] nums) {
        // int max=nums[0];
        //     for(int a:nums){
        //         if(max > a){
        //             max=a;
        //         }
        //     }
        //     return max;
        int l=0;
        int r=nums.length-1;
        int count=0;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else if(nums[mid]<nums[r]){
                r=mid;
            }else{
                r--;
            }
            count=l;
        }
        return nums[count];
    }
}