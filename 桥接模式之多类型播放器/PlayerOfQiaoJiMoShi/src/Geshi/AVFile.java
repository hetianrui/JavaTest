package Geshi;

public class AVFile implements VideoFIle {
    @Override
    public void decode(String osType, String fileName) {
        System.out.println("将播放："+fileName+", "+"文件格式为AV，系统为："+osType);
    }
}
