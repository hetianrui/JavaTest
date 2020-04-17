public class Keyboard implements USB {
    @Override
    public void open() {
        System.out.println("use keyboard");
    }

    @Override
    public void close() {
        System.out.println("close keyboard");
    }
}
