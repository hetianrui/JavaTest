package Geshi;

public class MPEGFile implements VideoFIle {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println("将播放："+fileName+", "+"文件格式为MPEG，系统为："+osType);

    }
}
