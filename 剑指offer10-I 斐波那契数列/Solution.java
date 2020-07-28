class Solution {
    public int fib(int n) {
        int max=0;
        int nums[]=new int[101];
        nums[0]=0;
        nums[1]=1;
        if(n==0){
            return nums[0];
        }
        if(n==1){
            return nums[1];
        }
        for(int i=2;i<=n;i++){
            nums[i]=(nums[i-1]+nums[i-2])%1000000007;
        }
        return nums[n];
    }
}