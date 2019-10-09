import java.util.ArrayList;
import java.util.List;

public class FrameList {
    private List<Frame> frames=new ArrayList<>();
    //private static int currentFrame;
    private int currentScore;
    public FrameList(){
    }
    public void nextFrame(Frame frame) {
        frames.add(frame);
        calculateCurrentScore();
    }
    public void calculateCurrentScore(){
        for(int i=0;i<Game.currentFrame;i++){
            if(!frames.get(i).isFinished()){
                switch (frames.get(i).getType()){
                    case SPARE:
                        if(i<9){
                            if(frames.get(i+1).howManyRolls()>0){
                                frames.get(i).addToScore(frames.get(i+1).getRolls().get(0).getPinCount());
                                currentScore+=frames.get(i).getScore();
                                frames.get(i).setFinalScore(currentScore);
                                frames.get(i).setFinished(true);
                            }
                        }
                        break;
                    case STRIKE:
                        if(i<9){
                            if(frames.get(i+1).howManyRolls()>1){
                                frames.get(i).addToScore(frames.get(i+1).getRolls().get(0).getPinCount());
                                frames.get(i).addToScore(frames.get(i+1).getRolls().get(1).getPinCount());
                                currentScore+=frames.get(i).getScore();
                                frames.get(i).setFinalScore(currentScore);
                                frames.get(i).setFinished(true);
                            }
                            else if(frames.get(i+1).howManyRolls()>0 && frames.get(i+2).howManyRolls()>0){
                                frames.get(i).addToScore(frames.get(i+1).getRolls().get(0).getPinCount());
                                frames.get(i).addToScore(frames.get(i+2).getRolls().get(0).getPinCount());
                                currentScore+=frames.get(i).getScore();
                                frames.get(i).setFinalScore(currentScore);
                                frames.get(i).setFinished(true);
                            }
                        }
                        break;
                }

            }
        }
    }
}
