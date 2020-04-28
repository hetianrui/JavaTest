package M4D28;

public class BinarySearch {
    public static void main(String[] args) {
     int arr[]={1,2,3,4,5,6,7,8};
        System.out.println(BSearch(arr,0,7,6));

    }
    public static int BSearch(int[] arr,int left,int right,int findval){
        int mid=(left+right)/2;
        if(findval==arr[mid]){
            return mid;
        }
        if(left>right){
            return -1;
        }
        if(findval<arr[mid]){
            return BSearch(arr,0,mid-1,findval);
        }
        if(findval>arr[mid]){
            return BSearch(arr,mid+1,right,findval);
        }
    return -1;
    }

}
