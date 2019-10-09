/**
 * This class simulates a roll from a player
 * @author Tre
 */
public class Roll {
    private int pinCount;

    /**
     * This creates a roll based on the amount of pins knocked over
     * @param pinCount
     */
    public Roll(int pinCount){
        this.pinCount=pinCount;
    }
    public int getPinCount(){
        return pinCount;
    }
}
