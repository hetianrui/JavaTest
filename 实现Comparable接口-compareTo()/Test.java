import java.util.Arrays;
import java.util.Comparator;

public class Test implements Comparable,Comparator{
    int price;
    String name;
    public Test(){}
    public Test(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String args[]) {

        Test arr[] = new Test[3];
        arr[0] = new Test(10, "Buoji");
        arr[1] = new Test(10, "ABouse");
        arr[2] = new Test(30, "Wanfa");
        Arrays.sort(arr,new Comparator(){
            @Override
            public  int compare(Object o1, Object o2) {
                if(o1 instanceof Test && o2 instanceof Test){
                    Test test1=new Test();
                    test1=(Test) o1;
                    Test test2=new Test();
                    test2=(Test) o2;
                    if(test1.price>test2.price){
                        return -1;
                    }else if(test1.price<test2.price){
                        return 1;
                    }else {
                        return test1.name.compareTo(test2.name);
                    }
                }
                throw new RuntimeException("输入类型有误");
            }
        });
        System.out.println(Arrays.toString(arr));

    }

    //@Override
    public int compareTo(Object o) {
        Test test=new Test();
        if(o instanceof Test){
             test = (Test) o;
        }
        if(this.price>test.price) {
            return 1;
        }else if(this.price<test.price){
            return -1;
        }else {
            return this.name.compareTo(test.name);
        }
    }

    @Override
    public  int compare(Object o1, Object o2) {
        if(o1 instanceof Test && o2 instanceof Test){
            Test test1=new Test();
            test1=(Test) o1;
            Test test2=new Test();
            test2=(Test) o2;
            if(test1.price>test2.price){
                return 1;
            }else if(test1.price<test2.price){
                return -1;
            }else {
                return 0;
            }
        }
        throw new RuntimeException("输入类型有误");
    }
}

