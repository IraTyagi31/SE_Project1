public class LaneEventUtil {
    public int frame;
    public int ball;
    public int index;
    public int frameNum;

    public LaneEventUtil(int theBall, int theIndex, int theFrameNum) {
        ball = theBall;
        index = theIndex;
        frameNum = theFrameNum;
    }

    public int getFrameNum() {
        return frameNum;
    }

    public int getIndex() {
        return index;
    }

    public int getFrame( ) {
        return frame;
    }

    public int getBall( ) {
        return ball;
    }
}
