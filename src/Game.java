public class Game {
    private PlayerList playerList;
    public Game(){
        for(int i=0;i<10;i++){
            playerList.doRound();
        }
    }
}
