package DuckShop;

class Solution {
    public int maxArea(int[] height) {

        // int res=0;
        // for(int i=0;i<height.length-1;i++){
        //     for (int j=i+1;j<height.length;j++){
        //         int count=Math.min(height[i],height[j])*(j-i);
        //         res=res>count ? res:count;
        //     }

        // }
        // return res;

        int res=0;
        int i=0,j=height.length-1;
        while(i<j){
            int count=Math.min(height[i],height[j])*(j-i);
            res=res>count ? res:count;
            if(height[i]>height[j]) j--;
            else i++;
        }
        return res;
    }
}