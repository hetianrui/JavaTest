public class SeqList {
    private int[] array;
    private int size;//保存array中已经有的数据个数

    public SeqList() {
        //初始化部分
        array = new int[5];
        this.size = 0;
        //
    }

    //头插
    public void pushFront(int element) {

        ensureCapacity();

        for (int i = size - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = element;
        size++;
    }

    //尾插
    public void pushBack(int element) {
        ensureCapacity();
        array[size++] = element;
    }

    //中间插入,index是插入的位置，element插入的元素
    public void insert(int index, int element) {
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;

    }

    //头删
    public void popFront() {
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    //尾删 默认删掉的数为0
    public void popBack() {
        array[--size] = 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

    }

    //扩容 内部使用的方法
    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        int a = array.length + array.length / 2;
        int[] newArray = new int[a];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        this.array=newArray;
       //原来的数组自动垃圾回收
    }

    //删掉所有element
    public void removeAll(int element) {
        int[] a = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] != element) {
                a[j++] = array[i];
            }
        }
        /*for (int i = 0; i < j; i++) {
            array[i] = a[i];
        }*/
        this.array=a;
        size = j;
    }

    public static void main(String[] args) {
        //int[] array=new int[10];
        SeqList a = new SeqList();
        a.pushFront(6);
        a.pushFront(7);
        a.pushFront(8);
        a.pushFront(8);
        a.pushFront(8);
        a.pushFront(8);
        a.display();
        a.removeAll(8);
        a.display();
    }
}