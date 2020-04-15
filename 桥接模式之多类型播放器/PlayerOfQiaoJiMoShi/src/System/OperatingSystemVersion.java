package System;

import Geshi.VideoFIle;

public abstract class OperatingSystemVersion  {
    VideoFIle VideoFile;

    public void setVideoFile(VideoFIle videoFile) {
        VideoFile = videoFile;
    }
    public abstract void play(String filename);
}
