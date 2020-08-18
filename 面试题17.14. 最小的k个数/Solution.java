class Solution {
    public int[] smallestK(int[] arr, int k) {
        int res[]=new int[k];
        if(k==0) return res;
        quickSort(arr,0,arr.length-1);
        // for(int i=0;i<k;i++){
        //     res[i]=arr[i];
        // }
        return Arrays.copyOfRange(arr, 0, k);
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int pivot=arr[l];
        while(l<r){
            while(l<r && arr[r]>=pivot){
                r--;
            }
            if(l<r){
                arr[l]=arr[r];
            }
            while(l<r && arr[l]<=pivot){
                l++;
            }
            if(l<r){
                arr[r]=arr[l];
            }
            
        }
        arr[l]=pivot;
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }
}