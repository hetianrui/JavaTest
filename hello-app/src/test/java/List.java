import java.util.Iterator;
public interface List {
    boolean add(int element);
     boolean add(int index,int element);
     int get(int index);
     int set(int index,int val);

     int remove(int index);

     int size();

     boolean isEmpty();

     Iterator iterator();
}
