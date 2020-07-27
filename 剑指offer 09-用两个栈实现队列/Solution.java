import java.util.Stack;

class CQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    public CQueue() {
        this.a=new Stack<>();
        this.b=new Stack<>();
    }
    public void appendTail(int value) {
        while(!a.isEmpty()){
            b.add(a.pop());
        }
        a.add(value);
        while(!b.isEmpty()){
            a.add(b.pop());
        }
    }
    public int deleteHead() {
        if(a.isEmpty()){
            return -1;
        }
        return a.pop();
    }
}