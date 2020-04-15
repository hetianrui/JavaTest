package Geshi;

public class WMVFile implements VideoFIle {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println("将播放："+fileName+", "+"文件格式为WMV，系统为："+osType);
    }
}
