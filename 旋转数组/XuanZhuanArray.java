package TestCode;

public class XuanZhuanArray {
    public static void rotate(int[] nums, int k) {
      int mid=k%nums.length;//先让移动的个数k对数组长度取余得到mid
      int num[]=new int[nums.length];
      for(int i=0;i<nums.length;i++){
          num[(i+mid)%num.length]=nums[i];//原数组的下标加上mid再对数组长度取余得到右移后的下标
      }
      for (int i=0;i<num.length;i++){
          nums[i]=num[i];
      }
    }

}
