import java.util.ArrayList;
import java.util.List;

public class Binary {
    public static void main(String[] args) {
               int arr[]={10,33,55,99,101,101,101,102,103};
        System.out.println(Search2(arr,0,arr.length-1,101));
    }
    public static int Search(int []arr,int left,int right,int aim){
        int mid=(left+right)/2;
        if(left>right){//如果是==号，对于奇数个元素来说，找到边界值时不会进行比较，直接输出-1
            return -1;
        }
        if(aim>arr[mid]){
            return Search(arr,mid+1,right,aim);//如果数组个数是奇数个，不写加1会陷入死循环，然后一直开辟栈空间，导致栈溢出
        }else if(aim<arr[mid]){
            return Search(arr,left,mid-1,aim);
        }else {
            return mid;
        }
    }
    public static List<Integer> Search2(int []arr, int left, int right, int aim){//对于含有重复元素的查找来说返回下标的集合
        int mid=(left+right)/2;
        List<Integer> list=new ArrayList<>();
        if(left>right){//如果是==号，对于奇数个元素来说，找到边界值时不会进行比较，直接输出-1
            return new ArrayList<>();
        }
        if(aim>arr[mid]){
             return Search2(arr,mid+1,right,aim);//如果数组个数是奇数个，不写加1会陷入死循环，然后一直开辟栈空间，导致栈溢出
        }else if(aim<arr[mid]){
             return Search2(arr,left,mid-1,aim);
        }else{
            list.add(mid);
          int index=mid-1;
          while (true){
              if(index<left||arr[index]!=arr[mid]){
                  break;
              }
              if(arr[index]==arr[mid]){
                  list.add(index--);
              }
          }
            index=mid+1;
            while (true){
                if(index>right||arr[index]!=arr[mid]){
                    break;
                }
                if(arr[index]==arr[mid]){
                    list.add(index++);
                }
            }
            return list;
        }

    }
}
