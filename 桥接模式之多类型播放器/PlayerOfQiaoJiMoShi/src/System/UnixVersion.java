package System;

public class UnixVersion extends OperatingSystemVersion {
    @Override
    public void play(String filename) {
    this.VideoFile.decode("Unix",filename);
    }
}
