//Name: Karen Guzman
// Computing ID: sae3gg
// Homework Name: HW3 - Basketball
// Resources used: https://www.baeldung.com/java-equals-hashcode-contracts
import java.util.Arrays;

public class Player {
    //declare all attributes
    private String name;
    private String position;
    private double pointsPerGame;
    private double fieldGoalPercentage;
    private double threePointPercentage;
    private double freeThrowPercentage;
    public Player(String name, String position, double pointPerGame, double fieldGoalPercentage, double threePointPercentage, double freeThrowPercentage){
        this.name = name;
        this.position = position;
        this.pointsPerGame = pointsPerGame;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowPercentage = freeThrowPercentage;
    }
    public Player(){
        name = " ";
        position = " ";
        pointsPerGame = 0;
        fieldGoalPercentage = 0;
        threePointPercentage =0;
        freeThrowPercentage = 0;
    }

    //toString method
    @Override
    public String toString() {
        return "Name: " + name + " Position: " + position + " Points per game: " + pointsPerGame + " Field goal percentage " + fieldGoalPercentage + " Three point percentage: " + threePointPercentage + " Free throw percentage " + freeThrowPercentage;
    }

    //get name
    public String getName() {
        return name;
    }
    //get position
    public String getPosition(){
        return position;
    }
    //get points per game
    public double getPointsPerGame(){
        return pointsPerGame;
    }
    //get field goal percentage
    public double getFGP(){
        return fieldGoalPercentage;
    }
    //get three point percentage
    public double getTPP(){
        return threePointPercentage;
    }
    //get free throw percentage
    public double getFTP(){
        return freeThrowPercentage;
    }

    //set name
    public void setName(String name){
        this.name = name;
    }

    //set position
    public void setPosition(String position) {
        //not case-sensitive but checks for valid position
        if (position.equalsIgnoreCase("guard")||position.equalsIgnoreCase("forward")||position.equalsIgnoreCase("center")){
            this.position = position;
        }
    }

    public Player getPlayer(){
        return this;
    }

    //set points per game (has to be greater than 0)
    public void setPointsPerGame(double pointsPerGame) {

        if(pointsPerGame>=0) this.pointsPerGame = pointsPerGame;
    }

    //set field goal percentage (has to be greater than 0)
    public void setFieldGoalPercentage(double fieldGoalPercentage) {
        if(fieldGoalPercentage>=0) this.fieldGoalPercentage = fieldGoalPercentage;
    }

    //set three point percentage (has to be greater than 0)
    public void setThreePointPercentage(double threePointPercentage) {
        if(threePointPercentage>=0) this.threePointPercentage = threePointPercentage;
    }

    //set free throw percentage (has to be greater than 0)
    public void setFreeThrowPercentage(double freeThrowPercentage) {
        if(freeThrowPercentage>=0) this.freeThrowPercentage = freeThrowPercentage;
    }
    //player equals
    @Override
    public boolean equals(Object obj) {
        //if null return false
        if(obj == null) {
            return false;}
        //if references point to the same address return true
        if(this==obj){return true;}
        //if obj is an instance of player, begin to compare data
        if(getClass()==obj.getClass()){
            Player otherPlayer = (Player) obj;
            return this.getName().equalsIgnoreCase(otherPlayer.getName()) && this.getPosition().equalsIgnoreCase(otherPlayer.getPosition()) && this.getPointsPerGame() == otherPlayer.getPointsPerGame() && this.getFGP() == otherPlayer.getFGP() && this.getTPP() == otherPlayer.getTPP() && this.getFTP() == otherPlayer.getFTP();
        }
        return false;
    }


//    public static void main(String[] args){
//        //make two identical players
//        Player ryanDunn = new Player("Ryan the bomb Dunn", "center", 9.4, 58.4, 24, 58.1);
//        Player reeceBeek = new Player("Ryan the bomb Dunn", "center", 9.4, 58.4, 24, 58.1);
//        //make teams that are identical
//        Player[] team1 = {ryanDunn, reeceBeek};
//        Player[] team2 = team1;
//        Player[] team3 = {ryanDunn, reeceBeek};
//        //check equals
//        System.out.println(Arrays.equals(team1, team3));
//        System.out.println(ryanDunn.equals(reeceBeek));
//        //check averages of FGP
//        //make teams that are identical
//        Team bigTeam1 = new Team(team1);
//        Team bigTeam2 = new Team(team3);
//        //check averages of FGP
//        System.out.println(bigTeam1.FGAverage());
//        //check equals for team
//        System.out.println(bigTeam1.equals(bigTeam2));
//    }
}





