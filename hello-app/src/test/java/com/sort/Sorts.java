/*package com.sort;

import java.util.Arrays;



public class Sorts implements Comparable<Sorts> {
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //有序区间 [0,i]
            //无序区间 [i+1,array.length)
            //待插入数据是array[i+1]
            int key = array[i];

            int j;
            for (j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    array[j-1]=array[j-1]^ array[j];
                    array[j] =array[j-1]^ array[j];
                    array[j-1] =array[j-1]^ array[j];
                }
                /**/
        //    }

      //  }

    //}
/*public int partition(int[] array,int left,int right){
        int pivot=array[right];
        int less=left;
        int great=right;
        while (less<great){
            while (less<great&&array[less]<=pivot){
            pivot=array[less];

        }
}*/
/*public static void partition(int[] array,int left,int right) {
    int l = left;
    int r = right;
    int pivot = array[right];
    if (l < r) {
        while (l < r && pivot >= array[l]) {
            r--;
            if (pivot >= array[l]) {
                array[l] = array[r];
                l++;
            }
        }
        while (l < r && pivot < array[r]) {
            l++;
            if ( pivot < array[r]) {
                array[r] = array[l];
                r--;
            }
        }

        array[l] = pivot;
        partition(array, left, r - 1);
        partition(array, r + 1, right);
    }
}
public static void mergeSort(int[] array,int low,int high) {
    int length = high - low;
    int[] extra = new int[length];
    if(low<high){
        return;
    }
    //[low,mid]
    //[mid,high]
    int mid=length/2;
    for (int i = 0; i < mid; i++) {
        int temp=0;
    if(array[i+1]>array[i]){
        temp=array[i];
        array[i]
        }
}
}

    //@Override
    public int compareTo(Sorts o) {
        return 0;
    }

     class Person implements Comparable<Person>{


         @Override
         public int compareTo(Person o) {
             return 0;
         }
     }


    public static void main(String[] args) {
    Sorts p=new Sorts();
        int[] array = new int[]{6,5,3,2};
        partition(array,0,3);
           //insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}*/
