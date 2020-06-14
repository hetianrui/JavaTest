
public class Test {
    public static int removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        int count=0;
        while(true){
            if(nums[left]==nums[right]){
                count++;
                right++;
            }else{
                if(count!=0){
                    nums[++left]=nums[right];
                }else{
                    left++;
                    right++;
                }
                count=0;
            }
            if(right==nums.length){
                break;
            }
        }
        return left+1;
    }
    public static void main(String args[]) {
     int nums[]={1,1,2};
        System.out.println(removeDuplicates(nums));;
    }
}

