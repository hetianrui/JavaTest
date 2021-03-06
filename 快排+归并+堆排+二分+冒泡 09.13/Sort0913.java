import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Sort0913 {
    public static void buildHeap(int []arr,int i,int n){
        int c1=2*i+1;
        int c2=2*i+2;
        int max=arr[i];
        int maxIndex=i;
        if(c2<=n && max<arr[c2]){
            max=arr[c2];
            maxIndex=c2;
        }
        if(c1 <= n && max < arr [c1]){
            max=arr[c1];
            maxIndex=c1;
        }
        if(max!=arr[i]){
            int temp=arr[i];
            arr[i]=arr[maxIndex];
            arr[maxIndex]=temp;
        }
    }
    public static void HeapSort(int []arr,int n){
        if(n<=0){
            return;
        }
        int i=(n-1)>>1;
        for (;i>=0;i--){
            buildHeap(arr,i,n);
        }
        int temp=arr[0];
        arr[0]=arr[n];
        arr[n]=temp;
        HeapSort(arr,n-1);
    }
    public static void quickSort(int []arr,int left,int right){
        if(left==right){
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
            while(l<r && arr[l]<=max){
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
            if(arr[l]>arr[r]){
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
    public static int BinarySort(int []arr,int left,int right,int target){
        if(left>right){
            return -1;
        }
        int mid=(left+right)>>1;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return BinarySort(arr,left,mid-1,target);
        }else {
            return BinarySort(arr,mid+1,right,target);
        }
    }
    public static void mergeSort(int []arr,int left,int right){
        if(left==right)return;
        int mid=(left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public static void BubbleSort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length  - i; j++) {
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void str(int x,String s){

        StringBuilder sb=new StringBuilder();

        for(int i=0,j=i+x;i<s.length() && j<s.length();i=j,j=j+x){
            sb.append(new StringBuilder(s.substring(i,j)).reverse());
        }
        if(sb.length()<s.length()){
            sb.append(new StringBuilder(s.substring(sb.length(),s.length())).reverse());
        }
        System.out.println(sb);
    }
    public static void res(BigInteger x, BigInteger y){
        x=x.multiply(BigInteger.valueOf(3));
        int xx=x.intValue();
        BigInteger count=BigInteger.valueOf(0);
        for(int i=1;i<=xx;i++){
            count=count.add(BigInteger.valueOf(i));
        }
        System.out.println(count.multiply(y));
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            res(sc.nextBigInteger(),sc.nextBigInteger());
        }
    }
}
