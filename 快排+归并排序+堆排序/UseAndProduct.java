package Scan;

import java.util.Arrays;

public class UseAndProduct {
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l=left;
        int r=mid+1;
        int t=0;
        while(l<=mid && r<=right){
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
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft++]=temp[t++];
        }
    }
    public static void mergeSort(int []arr,int left,int right,int[] temp){
        int mid=(left+right)/2;
        if(left==right){
            return;
        }
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int min=arr[l];
        while (l<r){
            while (l<r && arr[r]>=min){
                r--;
            }
            if(l<r){
                arr[l]=arr[r];
            }
            while (l<r && arr[l]<=min){
                l++;
            }
            if(l<r){
                arr[r]=arr[l];
            }
        }
        arr[l]=min;
        quickSort(arr,left,l);
        quickSort(arr,l+1,right);
    }
    public static void heap(int[] arr,int n,int i){
        int left=2*n+1;
        int right=2*n+2;
        int max=arr[n];
        int maxIndex=0;
        if(left<=i && arr[left]>max){
            max=arr[left];
            maxIndex=left;
        }
        if(right<=i && arr[right]>max){
            max=arr[right];
            maxIndex=right;
        }
        if(max!=arr[n]){
            int temp;
            temp=arr[maxIndex];
            arr[maxIndex]=arr[n];
            arr[n]=temp;
        }
    }
    public static void buildHeap(int []arr,int n){
        if(n<=0){
            return;
        }
        int i=(n-1)/2;
        int temp;
        for (;i>=0;i--){
            heap(arr,i,n);
        }
        temp=arr[0];
        arr[0]=arr[n];
        arr[n]=temp;
        buildHeap(arr,n-1);
    }
    public static void main(String[] args) {
        int []arr={4,5,6,1,2,3,7,0,6,99,-22};
        //mergeSort(arr,0,arr.length-1,new int[arr.length]);
        //quickSort(arr,0,arr.length-1);
        buildHeap(arr,arr.length-1);
        //heap(arr,2,7);
        System.out.println(Arrays.toString(arr));
    }
}

