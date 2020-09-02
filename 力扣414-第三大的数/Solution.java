class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        long res[]={Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE};
        int temp=0;
        for(int a:nums){
            if(a==res[0] || a==res[1] || a==res[2]) continue;
            if(a>res[2]){
                res[0]=res[1];
                res[1]=res[2];
                res[2]=a;         
            }else if(a>res[1]){
                res[0]=res[1];
                res[1]=a;
            }else if(a>res[0]){
                res[0]=a;
            }
        }
        if(res[0]==Long.MIN_VALUE){
            return (int)res[2];
        }else{
            return (int)res[0];
        }    
    }
}