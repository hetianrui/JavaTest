import java.util.Arrays;

public class Sort {
    public static void merge(int[] arr,int left,int mid,int right,int [] temp){
        int l=left;
        int r=mid+1;
        int t=0;
        while (l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp[t++]=arr[l++];
            }else {
                temp[t++]=arr[r++];
            }
        }
        while (l<=mid){
            temp[t++]=arr[l++];
        }
        while (r<=right){
            temp[t++]=arr[r++];
        }
        t=0;
        while (left<=right){
            arr[left++]=temp[t++];
        }
    }
    public static void mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right,new int[arr.length]);
    }
    public static void buildHeap(int[] arr,int i,int n){
        int c1=2*i+1;
        int c2=2*i+2;
        int max=arr[i];
        int maxIndex=0;
        if(c1<=n && arr[c1]>max){
            max=arr[c1];
            maxIndex=c1;
        }
        if(c2<=n && arr[c2]>max){
            max=arr[c2];
            maxIndex=c2;
        }
        if(max!=arr[i]){
            int temp=arr[i];
            arr[i]=max;
            arr[maxIndex]=temp;
        }
    }
    public static void HeapSort(int arr[],int n){
        if(n<=0){
            return;
        }
        int i=(n-1)/2;
        for (; i >=0 ; i--) {
            buildHeap(arr,i,n);
        }
        int temp=arr[0];
        arr[0]=arr[n];
        arr[n]=temp;
        HeapSort(arr,n-1);
    }
    public static void quick(int arr[],int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int max=arr[l];
        while (l<r){
            while (l<r && max<=arr[r]){
                r--;
            }
            if(l<r){
                arr[l]=arr[r];
            }
            while (l<r && max>=arr[l]){
                l++;
            }
            if(l<r){
                arr[r]=arr[l];
            }
        }
        arr[l]=max;
        quick(arr,left,l);
        quick(arr,l+1,right);
    }
    public static void main(String[] args) {
        int a[]={1,6,5,9,3,0,8};
        //mergeSort(a,0,a.length-1);
        //HeapSort(a,a.length-1);
        quick(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
