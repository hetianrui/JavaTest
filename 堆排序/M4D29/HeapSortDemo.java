package M4D29;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 1};
        HeapSortDemo heapSortDemo = new HeapSortDemo();
        heapSortDemo.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void buildHeap(int[] arr, int n) {
        for (int i = ((n - 1) - 1) / 2; i >= 0; i--) {
            heapfiy(arr, n, i);
        }
    }

    public void heapSort(int[] arr) {
        buildHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length - 1; i >= 0; i--) {
            Swap(arr, 0, i);
            System.out.println(Arrays.toString(arr));
            buildHeap(arr, i);
        }
    }

    public static void Swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void heapfiy(int[] arr, int n, int i) {
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && arr[max] < arr[c1]) {
            max = c1;
        }
        if (c2 < n && arr[max] < arr[c2]) {
            max = c2;
        }
        if (max != i) {
            Swap(arr, max, i);
            heapfiy(arr, n, max);
        }

    }
}
