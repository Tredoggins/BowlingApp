public class Player {
    private FrameList frameList;
    public void takeTurn(int roll1,int roll2){
        frameList.nextFrame(roll1,roll2);
    }
}
