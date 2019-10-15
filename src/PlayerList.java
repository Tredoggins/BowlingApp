import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<Player> players=new ArrayList<>();
    public PlayerList(int numOfPlayers){
        for(int i=0;i<numOfPlayers;i++){
            players.add(new Player(i+1));
        }
    }
    public void doRound(){
        for(Player p:players){
            p.takeTurn();
        }
    }
    public Player getWinner(){
        Player winner=players.get(0);
        for(Player p:players){
            if(p.getScore()>winner.getScore()){
                winner=p;
            }
        }
        return winner;
    }
    public void displayFinalCards(){
        for(Player p:players){
            p.getFrameList().calculateCurrentScore();
            UserInterface.displayScoreCard(p.getFrameList());
        }
    }
}
