import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<Player> players=new ArrayList<>();
    public void doRound(){
        for(Player p:players){
            p.takeTurn();
        }
    }
}
