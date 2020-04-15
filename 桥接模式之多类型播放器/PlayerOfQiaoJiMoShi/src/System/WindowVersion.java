package System;

public class WindowVersion extends OperatingSystemVersion {
    @Override
    public void play(String filename) {
        this.VideoFile.decode("Windows",filename);

    }
}
