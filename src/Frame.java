import java.util.ArrayList;
import java.util.List;

public class Frame {
    private FrameType type;
    private int score;
    private int finalScore;
    private boolean finished=false;
    private List<Roll> rolls=new ArrayList<Roll>();
    public Frame(){
    }
    public void addRoll(Roll roll){
        rolls.add(roll);
        addToScore(roll.getPinCount());
        determineType();
    }
    public int getScore(){
        return score;
    }
    public List<Roll> getRolls(){
        return rolls;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public FrameType getType(){
        return type;
    }
    public boolean isFinished() {
        return finished;
    }
    public int howManyRolls(){
        return rolls.size();
    }
    public void addToScore(int score){
        this.score+=score;
    }
    public void setFinalScore(int score){
        finalScore=score;
    }
    private void determineType(){
        if(rolls.size()>0 && rolls.get(0).getPinCount()==10){
            type=FrameType.STRIKE;
        }
        else if(rolls.size()>1 && rolls.get(0).getPinCount()+rolls.get(1).getPinCount()==10){
            type=FrameType.SPARE;
        }
        else if(rolls.size()>2 && rolls.get(0).getPinCount()==10 && rolls.get(1).getPinCount()==10){
            type=FrameType.DBLSTRIKE;
        }
        else{
            type=FrameType.NORMAL;
        }
    }
    @Override
    public String toString(){
        //do the thing to display frames
        return null;
    }
}
