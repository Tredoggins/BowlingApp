import java.util.Scanner;

public class UserInterface {
    private static Scanner keyboard = new Scanner(System.in);
    public static int getNumOfPins(){
        System.out.println("How Many Pins Were Knocked Down?");
        String input=keyboard.nextLine();
        int numOfPins=Integer.parseInt(input);
        if(numOfPins<=10) {
            return numOfPins;
        }
        else{
            System.out.println("That is more than 10 pins");
            return getNumOfPins();
        }
    }
    public static int getHowManyPlayers(){
        System.out.println("How many people are playing?");
        String input=keyboard.nextLine();
        int numOfPlayers=Integer.parseInt(input);
        return numOfPlayers;
    }
    public static void displayTop(Player player){
        System.out.println("Player "+player.getMyNum()+"   -   Frame #"+(Game.currentFrame+1));
    }
    public static void displayWinner(Player winner){
        System.out.println("Player "+winner.getMyNum()+" Wins!");
    }
}
