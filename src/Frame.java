import java.util.ArrayList;
import java.util.List;

public class Frame {
    private FrameType type;
    private int score;
    private int finalScore=0;
    private int frameNum;
    private boolean finished=false;
    private List<Roll> rolls=new ArrayList<Roll>();
    public Frame(){
        frameNum=Game.currentFrame+1;
    }
    public void addRoll(Roll roll){
        rolls.add(roll);
        determineType();
    }
    public int getScore(){
        return score;
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
    public Roll getRoll(int index){
        return rolls.get(index);
    }
    public void addToScore(int score){
        this.score+=score;
    }
    public void calculateWorkingScore(int extra){
        addToScore(rolls.get(0).getPinCount());
        if(!(type==FrameType.STRIKE)){
            addToScore(rolls.get(1).getPinCount());
            if(type==FrameType.FINALSTRIKE || type==FrameType.FINALSPARE){
                addToScore(rolls.get(2).getPinCount());
            }
        }
        addToScore(extra);
    }
    public void setFinalScore(int score){
        //if(finalScore==0) {
            finalScore = score;
        //}
    }
    public int getFinalScore(){
        return finalScore;
    }
    private void determineType(){
        if(rolls.size()>2 && rolls.get(0).getPinCount()==10){
            type=FrameType.FINALSTRIKE;
        }
        else if(rolls.size()>2 && rolls.get(0).getPinCount()+rolls.get(1).getPinCount()==10){
            type=FrameType.FINALSPARE;
        }
        else if(rolls.size()>0 && rolls.get(0).getPinCount()==10){
            type=FrameType.STRIKE;
        }
        else if(rolls.size()>1 && rolls.get(0).getPinCount()+rolls.get(1).getPinCount()==10){
            type=FrameType.SPARE;
        }
        else if(rolls.size()>1 && rolls.get(0).getPinCount()+rolls.get(1).getPinCount()<10){
            type=FrameType.NORMAL;
        }
    }
    public int getFrameNum(){
        return frameNum;
    }
    public String getDisplayRolls(){
        String display="";
        switch (type){
            case STRIKE:
                display+=" X ";
                break;
            case SPARE:
                if(rolls.get(0).getPinCount()==0){
                    display+="-";
                }
                else{
                    display+=rolls.get(0).getPinCount();
                }
                display+=" /";
                break;
            case NORMAL:
                if(rolls.get(0).getPinCount()==0){
                    display+="-";
                }
                else{
                    display+=rolls.get(0).getPinCount();
                }
                display+=" ";
                if(rolls.get(1).getPinCount()==0){
                    display+="-";
                }
                else{
                    display+=rolls.get(1).getPinCount();
                }
                break;
            case FINALSTRIKE:
                display+="X";
                if(rolls.get(1).getPinCount()==10){
                    display+="X";
                    if(rolls.get(2).getPinCount()==10){
                        display+="X";
                    }
                    else if(rolls.get(2).getPinCount()==0){
                        display+="-";
                    }
                    else{
                        display+=rolls.get(2).getPinCount();
                    }
                }
                else if(rolls.get(1).getPinCount()+rolls.get(2).getPinCount()==10){
                    if(rolls.get(1).getPinCount()==0){
                        display+="-";
                    }
                    else{
                        display+=rolls.get(1).getPinCount();
                    }
                    display+="/";
                }
                else if(rolls.get(1).getPinCount()==0){
                    display+="-";
                    if(rolls.get(2).getPinCount()==0){
                        display+="-";
                    }
                    else{
                        display+=rolls.get(2).getPinCount();
                    }
                }
                else {
                    display+=rolls.get(1).getPinCount()+""+rolls.get(2).getPinCount();
                }
                break;
            case FINALSPARE:
                if(rolls.get(0).getPinCount()==0){
                    display+="-";
                }
                else{
                    display+=rolls.get(0).getPinCount();
                }
                display+="/";
                if(rolls.get(2).getPinCount()==10){
                    display+="X";
                }
                else if(rolls.get(2).getPinCount()==0){
                    display+="-";
                }
                else{
                    display+=rolls.get(2).getPinCount();
                }
                break;
            default:
                display+="   ";
        }
        return display;
    }
}
