import java.util.ArrayList;
import java.util.List;

public class FrameList {
    private List<Frame> frames=new ArrayList<>();
    private int currentFrame;
    private int currentScore;
    private FrameList(){
        for(int i=0;i<9;i++){
            frames.add(new RegularFrame());
        }
        frames.add(new FinalFrame());
        currentFrame=0;
    }
    public void nextFrame(int roll1,int roll2){
        currentFrame++;
        //check for 10s
        //add rolls to current frame
    }
    public void calculateCurrentScore(){

    }
}
