class Solution {
    public int majorityElement(int[] nums) {
        // Map<Integer,Integer> map=new HashMap<>();
        // for(int a:nums){
        //     int i=map.getOrDefault(a,0);
        //     if(i+1 > nums.length/2 ){
        //         return a;
        //     }
        //     map.put(a,i+1);
        // }
        // return -1;
        int res = 0, count = 0,j=0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                res = nums[i];
                count++;
            }
            else
                j= res==nums[i] ? count++:count--;
        }
        return res;
    }
}