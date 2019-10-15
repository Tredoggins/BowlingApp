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
        UserInterface.displayScoreCard(this);
    }
    public void calculateCurrentScore(){
        for(int i=0;i<Game.currentFrame+1;i++){
            if(!frames.get(i).isFinished()){
                switch (frames.get(i).getType()){
                    case SPARE:
                        if(i<9){
                            if(frames.size()-1>i) {
                                currentScore-=frames.get(i).getScore();
                                if (frames.get(i + 1).howManyRolls() > 0) {
                                    frames.get(i).calculateWorkingScore(frames.get(i+1).getRoll(0).getPinCount());
                                    currentScore += frames.get(i).getScore();
                                    frames.get(i).setFinalScore(currentScore);
                                    frames.get(i).setFinished(true);
                                }
                            }
                        }
                        break;
                    case STRIKE:
                        if(i<9){
                            if(frames.size()-1>i) {
                                currentScore -= frames.get(i).getScore();
                                if (frames.get(i + 1).howManyRolls() > 1 && (frames.get(i+1).getRoll(0).getPinCount()<10 || frames.get(i+1).getType()==FrameType.FINALSTRIKE)) {
                                    frames.get(i).calculateWorkingScore(frames.get(i+1).getRoll(0).getPinCount()+frames.get(i+1).getRoll(1).getPinCount());
                                    currentScore += frames.get(i).getScore();
                                    frames.get(i).setFinalScore(currentScore);
                                    frames.get(i).setFinished(true);
                                }
                                else if(frames.size()-2>i) {
                                    if (frames.get(i + 1).howManyRolls() > 0 && frames.get(i + 2).howManyRolls() > 0) {
                                        frames.get(i).calculateWorkingScore(frames.get(i+1).getRoll(0).getPinCount()+frames.get(i+2).getRoll(0).getPinCount());
                                        currentScore += frames.get(i).getScore();
                                        frames.get(i).setFinalScore(currentScore);
                                        frames.get(i).setFinished(true);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        frames.get(i).calculateWorkingScore(0);
                        currentScore+=frames.get(i).getScore();
                        frames.get(i).setFinalScore(currentScore);
                        frames.get(i).setFinished(true);
                        break;
                }

            }
        }
    }
    public int getCurrentScore(){
        return currentScore;
    }
    public int getSize(){
        return frames.size();
    }
    public Frame getFrame(int index){
        return frames.get(index);
    }
}
