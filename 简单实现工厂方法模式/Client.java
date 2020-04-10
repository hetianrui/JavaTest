
public class Client {
    public static void main(String[] args) {
        FileLogFactory a=new FileLogFactory();
        a.createLog().writeLog();
        DatabaseLogFactory b=new DatabaseLogFactory();
        b.createLog().writeLog();

    }
}
