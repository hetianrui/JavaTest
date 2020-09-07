class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(arr.length==0 || k==0){
            return new int[k];
        }
        return quick(arr,0,arr.length-1,k-1);
    }
    public static int[] quick(int []num,int left,int right,int k){
        int j=quickSortSearch(num,left,right);
        if(j==k){
            int res[]=new int[k+1];
            for (int i = 0; i < res.length; i++) {
                res[i]=num[i];
            }
            return res;
        }
        return k>j ? quick(num,j+1,right,k):quick(num,left,j-1,k);
    }
    public static int quickSortSearch(int []num,int left,int right){
        int l=left;
        int r=right;
        int max=num[l];
        while (l<r){
            while (l<r && num[r]>=max){
                r--;
            }
            if(l<r){
                num[l]=num[r];
            }
            while (l<r && num[l]<=max){
                l++;
            }
            if(l<r){
                num[r]=num[l];
            }
        }
        num[l]=max;
        return l;
    }
}