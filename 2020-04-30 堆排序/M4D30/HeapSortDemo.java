package M4D30;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr=new int[800000];
  for(int i=0;i<arr.length;i++){
      arr[i]=new Random().nextInt(800000);
  }
        System.out.println(new Date());
        new HeapSortDemo().heapsort(arr);
        System.out.println(new Date());

    }
    public void heapsort(int[] arr){
        new HeapSortDemo().createHeap(arr,arr.length);

        for(int i=arr.length-1;i>=0;i--){
            swap(arr,0,i);
            createHeap(arr,i);
        }
    }
    public void createHeap(int[] arr,int n){
       for(int i=((n-1)-1)/2;i>=0;i--){
           new HeapSortDemo().Heapify(arr,n,i);
       }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void Heapify(int[] arr,int n,int i ){
        int c1=2*i+1;
        int c2=2*i+2;
        int max=i;
        if(c1 < n && arr[c1]>arr[max]){
            max=c1;
        }
        if(c2 < n && arr[c2]>arr[max]){
            max=c2;
        }
        if(max!=i){
            swap(arr,max,i);
            Heapify(arr,n,max);
        }
    }
}
