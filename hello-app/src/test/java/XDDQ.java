import java.util.Iterator;

public class XDDQ implements List{
    private static Node X;
    int array[];
    int size;

    public boolean add(int element) {
        array[size]=element;
        size++;
        return false;
    }

    public boolean add(int index, int element) {
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
        return false;
    }

    public int get(int index) {
        for (int i = 0; i < size; i++) {
            if (array[i] == array[index]) {
                return array[i];
            }
        }
        return 0;
    }

    public int set(int index, int val) {

        return 0;
    }

    public int remove(int index) { return 0; }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator iterator() {
        return null;
    }
}
