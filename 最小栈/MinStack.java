import java.util.Stack;

public class MinStack {
    private Stack<Integer> normal=new Stack<>();
    private Stack<Integer> min=new Stack<>();
    public void push(int x){
        normal.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            int m=min.peek();
            if(x<=m){
                min.push(x);
            }else {
                min.push(m);
            }
        }
    }
    public void pop(){
        normal.pop();
        min.pop();
    }
    public int top(){
        return normal.peek();
    }
    public int getMin(){
        return min.peek();
    }
}
