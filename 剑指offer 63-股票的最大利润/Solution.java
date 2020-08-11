class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int k=0,res=0,min=prices[0];
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i-1]);
            res=Math.max(res,prices[i]-min);
        }
        return res;
    }
}