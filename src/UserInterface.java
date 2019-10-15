import java.util.Scanner;

public class UserInterface {
    private static Scanner keyboard = new Scanner(System.in);
    public static int getNumOfPins(){
        System.out.print("How Many Pins Were Knocked Down? ");
        String input=keyboard.nextLine();
        try {
            int numOfPins = Integer.parseInt(input);
            if (numOfPins <= 10) {
                return numOfPins;
            } else {
                System.out.println("That is more than 10 pins");
                return getNumOfPins();
            }
        }
        catch (Exception e){
            System.out.println("That is not a valid input, please try again");
            return getNumOfPins();
        }
    }
    public static int getHowManyPlayers(){
        System.out.print("How many people are playing? ");
        String input=keyboard.nextLine();
        int numOfPlayers=Integer.parseInt(input);
        if(numOfPlayers>0) {
            return numOfPlayers;
        }
        else {
            System.out.println("Number of people must be greater than zero");
            return getHowManyPlayers();
        }
    }
    public static String getName(int playerNum){
        System.out.print("Player "+playerNum+"'s Name: ");
        String name=keyboard.nextLine();
        if(name.length()<10) {
            return name;
        }
        else{
            System.out.println("Name must be less than 10 characters.");
            return getName(playerNum);
        }
    }
    public static void displayTop(Player player){
        System.out.println("Player "+player.getMyNum()+" / "+player.getName()+"  -  Frame #"+(Game.currentFrame+1));
        System.out.println("--------------------------------------------------");
    }
    public static void displayWinner(Player winner){
        System.out.println("Player "+winner.getMyNum()+" Wins!");
    }
    private static void displayFrameNum(FrameList frameList){
        Frame frame;
        for(int i=0;i<frameList.getSize();i++) {
            frame=frameList.getFrame(i);
            String spaces = " ";
            if ((frame.getFrameNum() + "").length() < 2) {
                spaces += " ";
            }
            System.out.print("|  " + frame.getFrameNum() + spaces + " |");
        }
    }
    private static void displayFrameBar(FrameList frameList){
        for(int i=0;i<frameList.getSize();i++) {
            System.out.print("|------|");
        }
    }
    private static void displayFrameRolls(FrameList frameList){
        Frame frame;
        String spaces;
        for(int i=0;i<frameList.getSize();i++) {
            frame=frameList.getFrame(i);
            spaces="";
            for(int n=0;n<((5-frame.getDisplayRolls().length()));n++){
                spaces+=" ";
            }
            System.out.print("| "+frame.getDisplayRolls()+spaces+"|");
        }
    }
    private static void displayFrameScore(FrameList frameList){
        Frame frame;
        String spaces;
        for(int i=0;i<frameList.getSize();i++) {
            frame=frameList.getFrame(i);
            if(frame.getFinalScore()==0 && (frame.getRoll(0).getPinCount()>0 || frame.getRoll(1).getPinCount()>0)) {
                System.out.print("|      |");
            }
            else{
                spaces = "";
                for (int n = 0; n < ((5 - (frame.getFinalScore() + "").length()) - 1); n++) {
                    spaces += " ";
                }
                System.out.print("|  " + frame.getFinalScore() + spaces + "|");
            }
        }
    }
    public static void displayFrame(Frame frame){
        String spaces=" ";
        if((frame.getFrameNum()+"").length()<2){
            spaces+=" ";
        }
        System.out.println("|  "+frame.getFrameNum()+spaces+" |");
        System.out.println("|------|");
        spaces="";
        for(int i=0;i<((5-frame.getDisplayRolls().length()));i++){
            spaces+=" ";
        }
        System.out.println("| "+frame.getDisplayRolls()+spaces+"|");
        spaces="";
        for(int i=0;i<((5-(frame.getFinalScore()+"").length())-1);i++){
            spaces+=" ";
        }
        System.out.println("|  "+frame.getFinalScore()+spaces+"|");

    }
    public static void displayScoreCard(FrameList frameList){
        displayFrameNum(frameList);
        System.out.println();
        displayFrameBar(frameList);
        System.out.println();
        displayFrameRolls(frameList);
        System.out.println();
        displayFrameScore(frameList);
        System.out.println();
        System.out.println("Total Score: "+frameList.getCurrentScore());
    }
}
