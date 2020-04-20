import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MyRadixSort {
    public static void main(String[] args) {
        int a[]=new int[800];
        for(int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(8000);
        }
        System.out.println(new Date());
        radixsort(a);
        System.out.println(new Date());
    }
    public static void radixsort(int[] arr){
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxlength=(max+"").length();//最大数的位数代表整体的排序次数，因为要从个位，十位...排序

        for (int i=0;i<maxlength;i++){
            int bucket[][]=new int[10][arr.length];//定义十个桶，列数为排序数组数的个数
            int extra[]=new int[10];//该数组存放的是每个桶里面的数的个数
            for(int j=0;j<arr.length;j++){
               int dig=arr[j]/(int)(Math.pow(10,i))%10;//求出每一位的数字，代表放哪个桶
               bucket[dig][extra[dig]++]=arr[j];//所求余数为哪个桶，extra[dig]正好从0开始，存一个就++
            }
            int index=0;
            for(int l=0;l<extra.length;l++){//开始从桶里面取元素，extra.length代表桶的个数
                if(extra[l]!=0){//如果当前桶的元素个数不为0
                    for(int m=0;m<extra[l];m++){//循环元素的个数放回原数组
                        arr[index++]=bucket[l][m];//index就是遍历arr的指针，行l代表哪个桶，m是数的个数
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }
}
