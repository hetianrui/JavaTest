public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("use Mouse");
    }

    @Override
    public void close() {
        System.out.println("close Mouse");
    }
}
