import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue=new LinkedList<>();
    public void push(int x){
        queue.add( x);
    }
    public int pop(){
        int size=queue.size();
        for(int i=0;i<size-1;i++){
            int v=queue.poll();//队列的poll方法是检索删除队列头，队列为空并返回空
            //remove的方法是检索删除头，不考虑队列为空的情况
            queue.add(v);
        }
        return queue.poll();
    }
    public int top(){
        int size=queue.size();
        for(int i=0;i<size-1;i++) {
            int v = queue.poll();
            queue.add(v);

        }
        return queue.peek();
    }
    public boolean empty(){
      return queue.isEmpty();
    }
}
