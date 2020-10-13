import java.util.Arrays;

public class Sort1013 {
    public static void buildHeap(int []arr,int i, int n){
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
            int temp=arr[i];
            arr[i]=arr[maxIndex];
            arr[maxIndex]=temp;
        }
    }
    public static void HeapSort(int []arr,int n){
        if(n<=0) return;
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
        if(left>=right) return;
        int l=left;
        int r=right;
        int max=arr[left];
        while (l<r){
            while (l<r && arr[r]>=max) r--;
            if(l<r) arr[l]=arr[r];
            while (l<r && arr[l]<=max) l++;
            if(l<r) arr[r]=arr[l];
        }
        arr[l]=max;
        quickSort(arr,left,l);
        quickSort(arr,l+1,right);
    }
    public static void merge(int []arr,int left,int mid,int right){
        int l=left;
        int r=mid+1;
        int temp[]=new int[arr.length];
        int t=0;
        while (l<=mid && r<=right){
            if(arr[l]>arr[r]){
                temp[t++]=arr[r++];
            }else {
                temp[t++]=arr[l++];
            }
        }
        while (l<=mid) temp[t++]=arr[l++];
        while (r<=right) temp[t++]=arr[r++];
        t=0;
        while (left<=right){
            arr[left++]=temp[t++];
        }
    }
    public static void mergeSort(int []arr,int left,int right){
        if(left>=right) return;
        int mid=(left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public static void bubbleSort(int []arr){
        boolean flag=false;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(flag){
                flag=false;
            }else {
                break;
            }
        }
    }
    public static void main(String[] args) {
      int []arr={6,2,4,894,321,64,3,2};
      //mergeSort(arr,0,arr.length-1);
    //quickSort(arr,0,arr.length-1);
   //HeapSort(arr,arr.length-1);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
class MyBank{
    private MyBank(){}
    private static MyBank sc=new MyBank();
    public static MyBank getMyBank(){
        return sc;
    }
}
class Singleton{
    private Singleton(){

    }
    private volatile static Singleton sc=null;
    public static Singleton getSc(){
        if(sc==null){
            synchronized (Singleton.class){
                if(sc==null){
                    sc=new Singleton();
                    return sc;
                }
            }
        }
        return sc;
    }
}
class MyCount{
    static int count=0;

    public static void main(String[] args) {
        pro p=new pro();
        user u=new user();
        p.start();
        u.start();


    }
}
class pro extends Thread{
    public pro(){}
    @Override
    public void run() {
        while (true){
            synchronized (MyCount.class){
                if(MyCount.count<=0){
                    MyCount.count++;
                    System.out.println("生产者生产1后还有"+MyCount.count);
                    MyCount.class.notify();
                }else {
                    try {
                        MyCount.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
class user extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (MyCount.class){
                if(MyCount.count>0){
                    System.out.println("消费者消费1后还有"+ --MyCount.count);
                    MyCount.class.notify();
                }else {
                    try {
                        MyCount.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}