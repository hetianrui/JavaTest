package Erchashu;

public class Heaps {
    /*
    前提：除了index和它的孩子外，其他位置已经满足堆的性质了


     **/
    public  static void heapify(int[] array,int size,int index){
        while(true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            int max = left;
            if (left + 1 < size) {
                if (array[index] >= array[max]) {
                    return;
                }
                swap(array, index, max);
                index = max;
            }
        }
    }


    public static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    public static void creatHeap(int[] array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array,size,1);
        }
    }
    public static void adjust(int[] array,int index){
     if(index==0){
         return;
     }
     int parent=(index-1)/2;
     if(array[parent]>=array[index]){
         return;
     }
    }
}
