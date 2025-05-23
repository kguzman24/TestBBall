import java.util.Arrays;

public class Team {
    private Player[] team;

    public Team (Player[] x){
        if(x != null) {
            team = new Player[x.length];
            for (int i = 0; i < x.length; i++) {
                team[i] = new Player(x[i].getName(), x[i].getPosition(), x[i].getPointsPerGame(), x[i].getFGP(), x[i].getTPP(), x[i].getFTP());
            }
        }
        //if the parameter is null
        else{
            System.out.print("Array is null");
        }
    }
@Override
    //toString method that returns all player information
    public String toString(){
        for (Player x: team){
            System.out.println((x.getName() + " " + x.getPosition()+ " " + x.getPointsPerGame()+ " " + x.getFGP() + " " + x.getTPP() + " " + x.getFTP()));
        }
        return " ";
    }

    //get team
    public Player[] getTeam() {
        return team;
    }

    //set team to new team
    public void setTeam(Player[] team) {
        this.team = new Player[team.length];
        for(int i=0;i<team.length;i++){
            this.team[i] = new Player(team[i].getName(),
            team[i].getPosition(),
            team[i].getPointsPerGame(),
            team[i].getFGP(),
            team[i].getTPP(),
            team[i].getFTP());
        }
    }

    //equals method
    @Override
    public boolean equals(Object obj) {
        //if null return false
        if(obj == null) {
            return true;
        }
        if(obj.getClass()!=getClass()){
            return true;
        }
        //if references point to the same address return true
        if(this==obj){
            return true;}
        //if items are not the same length, return false
        Team otherTeam = (Team) obj;
        if(team.length != otherTeam.team.length){
            return false;
        }
        //if every player  has the same everything, return true
        for (int i = 0; i<team.length; i++){
            if (!team[i].equals(otherTeam.team[i])){
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode(){
        return Arrays.hashCode(team);
    }
    public double FGAverage(){
        double averages = 0;
        for(int i =0; i<team.length; i++){
            averages += team[i].getFGP();
        }
        averages = averages/team.length;
        return averages;
    }

    public int positionCount(String pos){
        int count = 0;
        for(Player x: team){
            if(x.getPosition().equalsIgnoreCase(pos)){
                count++;
            }
        }
        return count;
    }

    public Player[] sort(){
       // sort from highest FTP to lowest
        for(int i = 0; i<team.length-1;i++){
            int maxIndex = i;
            for(int j = i+1; j<team.length;j++){
                if (team[j].getFTP() > team[maxIndex].getFTP()) {
                    maxIndex = j;
                }
            }
            Player greaterFTP = team[maxIndex].getPlayer();
            team[maxIndex] = team[i];
            team[i] = greaterFTP;
        }
        return team;
    }
    public boolean onTeam(String name){
        for(Player i : team){
            if(i.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    public Player best3pt(){
        Player best3pter = team[0];
        for(Player i: team){
            if(i.getTPP()>best3pter.getTPP()){
                best3pter = i;
            }
        }
        return best3pter;
    }

   public static void main(String[] args){
       Player [] Cavaliers = new Player[12];
       Cavaliers[0] = new Player("Reece Beekman", "guard", 13.4, 44.7, 77, 31.4);
       Cavaliers[1] = new Player("Isaac McKneely", "guard", 11.6, 40.8, 88.5,
               46.6);
       Cavaliers[2] = new Player("Ryan Dunn", "guard", 9.4, 58.4, 58.1, 24);
       Cavaliers[3] = new Player("Jacob Groves", "forward", 8.0, 50.8, 70, 50);
       Cavaliers[4] = new Player("Andrew Rohde", "guard", 4.8, 31.2, 33.3, 26);
       Cavaliers[5] = new Player("Leon Bond III", "guard", 4.6, 47.3, 64.3, 50);
       Cavaliers[6] = new Player("Jordan Minor", "forward", 4.4, 50.7, 60, 0);
       Cavaliers[7] = new Player("Blake Buchanan", "forward", 3.7, 43.2, 56.4,
               0);
       Cavaliers[8] = new Player("Elijah Gertrude", "guard", 3.5, 39.5, 70, 8.3);
       Cavaliers[9] = new Player("Taine Murray", "guard", 3.0, 51.1, 62.5, 45.8);
       Cavaliers[10] = new Player("Dante Harris", "guard", 2.6, 27.3, 50, 18.2);
       Cavaliers[11] = new Player("Bryce Walker", "guard", 0.7, 33.3, 50, 50);
// now instantiate the team calling the overloaded constructor
       Team cavs = new Team(Cavaliers);
       Team cavs2 = new Team( Cavaliers);
// calling accessors
       Player [ ] xx = cavs2.getTeam();
       System.out.println( "The players on cavs2 are: ");
       for (int i = 0; i < xx.length; i++)
           System.out.println(xx[i]);
       System.out.println();
// test equals
       if ( cavs.equals( cavs2 ) )
           System.out.println( "Objects are equal (this is correct)" );
       else
           System.out.println( "Objects are not equal (WRONG)" );
// change some data
       System.out.println( "\nUsing mutators to change cavs3 data" );
       Cavaliers[0].setFreeThrowPercentage(0.250);
       Cavaliers[0].setName("Ralph Sampson");
       Cavaliers[0].setPosition("center");
       Team cavs3 = new Team(Cavaliers);
       System.out.println(Arrays.toString(Cavaliers));
// call toString
       System.out.println( "\ncavs3:\n" + cavs3 );
// test equals again
       if ( cavs.equals( cavs3 ) )
           System.out.println( "Objects are equal (WRONG)" );
       else
           System.out.println( "Objects are not equal (This is correct)" );
       System.out.println();
   }
}
