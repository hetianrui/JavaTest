import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();
    public void push(int x){
        stack1.push(x);
    }
    public int pop(){
        int size=stack1.size();
        if(stack2.isEmpty()){
            for (int i=0;i<size;i++){
                int v=stack1.pop();
                stack2.add(v);
            }
        }
        return stack2.pop();
    }

    public int peek(){
        int size=stack1.size();
        if(stack2.isEmpty()){
            for (int i=0;i<size;i++){
                int v=stack1.pop();
                stack2.add(v);
            }
        }
        return stack2.peek();
    }


    public boolean empty() {
        return stack2.isEmpty()&&stack1.isEmpty();
    }
}
