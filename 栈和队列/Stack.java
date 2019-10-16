public class Stack {
    private int[] array=new int[10];
    private int top=0;
    private void ensureCapacity()
    {
        if(top<array.length){
            return;
        }
    }
    public int push(int element) {
        ensureCapacity();
        array[top++]=element;
        return element;
    }

    public int pop() {
        return array[--top];
    }

    public int peek() {
        return array[top-1];
    }

    public boolean isEmpty() {
        return top==0;
    }

    public int size() {
        return top;
    }
public int search(int elemnt){
        for(int i=0;i<top;i++){
            if(array[i]==elemnt){
                return i;
            }
        }
        return -1;
}
}
