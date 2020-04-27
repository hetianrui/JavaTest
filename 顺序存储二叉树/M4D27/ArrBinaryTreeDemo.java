package M4D27;

import java.util.Arrays;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree binaryTree=new BinaryTree(arr);
        binaryTree.preOrder();
    }

}
class BinaryTree{
    private int arr[];

    public BinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index){
        if(arr.length==0){
            System.out.println("null");
            return;
        }
        System.out.println(arr[index]);
        if((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }
}