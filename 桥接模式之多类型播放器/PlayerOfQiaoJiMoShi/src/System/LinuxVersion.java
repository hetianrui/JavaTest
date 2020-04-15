package System;

public class LinuxVersion extends OperatingSystemVersion {
    @Override
    public void play(String filename) {
        this.VideoFile.decode("Linux",filename);
    }
}
