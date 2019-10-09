import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
    private FrameType type;
    private int score;
    private List<Roll> rolls=new ArrayList<Roll>();
    public Frame(){
    }
    public void addRoll(int roll){
        rolls.add(new Roll(roll));
    }
}
