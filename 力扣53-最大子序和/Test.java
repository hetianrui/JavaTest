public class Test {
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp = 0;
        for (int i=0;i<nums.length;i++){
            if(temp < 0){
                temp=nums[i];
            }else{
                temp+=nums[i];
            }
            res=res>temp? res:temp;
        }

        return res;
    }
    public static void main(String[] args) {
        int a[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
//        ApplicationContext context=
//                new ClassPathXmlApplicationContext("a.xml");
//        Object o=context.getBean("myName");
//        System.out.println(o.getClass());
//        System.out.println(o);
//        Object o1=context.getBean("myName");
//        System.out.println(o1.getClass());
//        System.out.println(o1);
//        System.out.println(o==o1);
    }
}
