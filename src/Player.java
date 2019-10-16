import java.util.ArrayList;
import java.util.Collection;

public class Player {
    private FrameList frameList;
    private int playerNum;
    private String name;
    public Player(int playerNum){
        this.playerNum=playerNum;
        name=UserInterface.getName(playerNum);
        frameList=new FrameList();
    }
    public void takeTurn() {
        UserInterface.displayTop(this);
        Frame frame = new Frame();
        Roll roll = new Roll(UserInterface.getNumOfPins());
        int pinCount = roll.getPinCount();
        frame.addRoll(roll);
        if (roll.getPinCount() < 10) {
            roll = new Roll(UserInterface.getNumOfPins());
            pinCount += roll.getPinCount();
        }
        else if(Game.currentFrame<9){
            roll=new Roll(0);
        }
        else{
            roll=new Roll(UserInterface.getNumOfPins());
        }
        if (pinCount > 10) {
            //System.out.println("That is not a valid roll, please re-enter the rolls for this frame");
            UserInterface.displaySomething("That is not a valid roll, please re-enter the rolls for this frame");
            takeTurn();
        }
        else{
            frame.addRoll(roll);
            if ((frame.getType() == FrameType.SPARE || frame.getType() == FrameType.STRIKE) && Game.currentFrame == 9) {
                frame.addRoll(new Roll(UserInterface.getNumOfPins()));
            }
            frameList.nextFrame(frame);
        }
    }
    public int getMyNum(){
        return playerNum;
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return frameList.getCurrentScore();
    }
    public FrameList getFrameList(){
        return frameList;
    }
}
