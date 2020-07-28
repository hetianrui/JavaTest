class Solution {
    public int numWays(int n) {
        if(n<=0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int j=1,k=2;
        int count=0;
        for(int i=3;i<n+1;i++){
            count=(j+k)%1000000007;
            j=k;
            k=count;
        }
        return count;
    }
}