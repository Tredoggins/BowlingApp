public class Game {
    private PlayerList playerList;
    public static int currentFrame;
    public Game(){
        playerList=new PlayerList(UserInterface.getHowManyPlayers());
        for(int i=0;i<10;i++){
            currentFrame=i;
            playerList.doRound();
        }
        UserInterface.displayWinner(playerList.getWinner());
        UserInterface.displayScoreCard(playerList.getWinner().getFrameList());
    }
}
