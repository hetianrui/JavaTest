public class DatabaseLogFactory extends LogFactory {
    @Override
    public Log createLog() {
        return new DatabaseLog();
    }
}
