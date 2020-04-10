public class FileLogFactory extends LogFactory {
    @Override
    public Log createLog() {
        return new FileLog();
    }
}
