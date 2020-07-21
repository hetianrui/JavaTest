public class Solution {
    public int findRepeatNumber(int[] nums) {
        // Map<Integer,Integer> map=new HashMap<>();
        // for(int a:nums){
        //     int b = map.getOrDefault(a, 0);
        //     if(b>=1){
        //         return a;
        //     }
        //     map.put(a,b+1);
        // }
        // return -1;
        int[] a=new int[nums.length];
        for(int b : nums){
            a[b]++;
            if(a[b]>1)
                return b;
        }
        return -1;
    }
}