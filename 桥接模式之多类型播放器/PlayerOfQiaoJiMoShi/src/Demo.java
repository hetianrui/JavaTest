import Geshi.AVFile;
import Geshi.MPEGFile;
import Geshi.RMVBFile;
import Geshi.WMVFile;
import System.*;
public class Demo {
    public static void main(String[] args) {
        WindowVersion windowVersion=new WindowVersion();
        windowVersion.setVideoFile(new AVFile());
        windowVersion.play("三国演义");
        windowVersion.setVideoFile(new WMVFile());
        windowVersion.play("三国演义");

        LinuxVersion linuxVersion=new LinuxVersion();
        linuxVersion.setVideoFile(new RMVBFile());
        linuxVersion.play("水浒传");

        UnixVersion unixVersion=new UnixVersion();
        unixVersion.setVideoFile(new MPEGFile());
        unixVersion.play("红楼梦");
    }
}
