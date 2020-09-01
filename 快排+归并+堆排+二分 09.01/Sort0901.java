public class Sort0901 {
    public static void quickSort(int []arr,int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int max=arr[l];
        while (l<r){
            while (l<r && arr[r]>=max){
                r--;
            }
            if(l<r){
                arr[l]=arr[r];
            }
            while (l<r && arr[l]<=max){
                l++;
            }
            if(l<r){
                arr[r]=arr[l];
            }
        }
        arr[l]=max;
        quickSort(arr,left,l);
        quickSort(arr,l+1,right);
    }
    public static void merge(int []arr,int left,int mid,int right){
        int l=left;
        int r=mid+1;
        int t=0;
        int []temp=new int[arr.length];
        while (l<=mid && r<=right){
            if(arr[l]>=arr[r]){
                temp[t++]=arr[r++];
            }else {
                temp[t++]=arr[l++];
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
    public static void mergeSort(int []arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public static void BuildHeap(int []arr,int i,int n){
        int c1=2*i+1;
        int c2=2*i+2;
        int max=arr[i];
        int maxIndex=i;
        if(c1<=n && arr[c1]>max){
            max=arr[c1];
            maxIndex=c1;
        }
        if(c2<=n && arr[c2]>max){
            max=arr[c2];
            maxIndex=c2;
        }
        if(max!=arr[i]){
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[i];
            arr[i]=temp;
        }
    }
    public static void HeapSort(int []arr, int n){
        if(n<=0){
            return;
        }
        int i=(n-1)>>1;
        for (;i>=0;i--){
            BuildHeap(arr,i,n);
        }
        int temp=arr[0];
        arr[0]=arr[n];
        arr[n]=temp;
        HeapSort(arr,n-1);
    }
public static int BinarySearch(int []arr,int left,int right,int target){
        if(left>right){
            return -1;
        }
        int mid=(left+right)>>1;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return BinarySearch(arr,left,mid-1,target);
        }
        if(arr[mid]<target){
            return BinarySearch(arr,mid+1,right,target);
        }
        return -1;
}
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,78,99};
//        HeapSort(arr,arr.length-1);
//        mergeSort(arr,0,arr.length-1);
//        quickSort(arr,0,arr.length-1);
        System.out.println(BinarySearch(arr,0,arr.length-1,55));
    }
}
