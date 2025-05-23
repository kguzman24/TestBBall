/* Team Client
 * Tests information for a basketball team
 */
public class TeamClient
{
    public static void main( String [] args )
    {
        Player r = new Player("AAA", "guard", 1, 2,3, 4);
        Player q = new Player("BBB", "guard", 1, 2, 3, 4);
        if (r.equals(q))
            System.out.println("equal - incorrect");
        else
            System.out.println("not equal - correct");
        q.setName("AAA");
        if (r.equals(q))
            System.out.println("equal - correct");
        else
            System.out.println("not equal - incorrect");
        boolean good = false;
        Player[] arr = new Player[3];
        arr[0] = new Player("AAA", "guard", 20, 20, 20, 20);
        arr[1] = new Player("BBB", "center", 10, 10, 10, 10);
        arr[2] = new Player("CCC", "forward", 30, 30, 30, 30);
        Team t = new Team(arr);
        Player[] answer = t.getTeam();
        if (answer.length == 3)
            good = true;
// did you make a shallow or deep copy of arr?
        arr[0].setName("Reece Beekman");
        if (arrequals(arr, answer)) {
            good = false;
            System.out.println("Forgot to make a deep copy!");
        }
        Player[] arr2 = new Player[2];
        arr2[0] = new Player("DDD", "guard", 21, 21, 21, 21);
        arr2[1] = new Player("EEE", "forward", 15, 15, 15, 15);
        t.setTeam(arr2);
        answer = t.getTeam();
        if (good && answer.length == 2)
            good = true;
        else
            good = false;
        if (good) System.out.println("Good so far...");
// gonna change arr2 contents
        arr2[0] = new Player("Reece Beekman", "guard", 13.4, 44.7, 77, 31.4);
        arr2[1].setName("Ryan Dunn");
// now let's see if answer is a shallow or deep copy of team :)
// did you make a shallow or deep copy of arr?
        if (arrequals(arr2, answer)) {
            good = false;
            System.out.println((arrequals(arr2, answer)));
            System.out.println("Forgot to make a deep copy!");
        }
// Testing with some real data
//first let's create an array of Players
        Player [] Cavaliers = new Player[12];
        Cavaliers[0] = new Player("Reece Beekman", "guard", 13.4, 44.7, 77, 31.4);
// System.out.println(Cavaliers[0].getName() + " " + Cavaliers[0].getPosition() + " " + Cavaliers[0].getPointsPerGame());
// System.out.println(Cavaliers[0]);
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
// now let's print the team (call toString)
        System.out.println(cavs);
// instantiate identical object
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
// call toString
        System.out.println( "\ncavs3:\n" + cavs3 );
// test equals again
        if ( cavs.equals( cavs3 ) )
            System.out.println( "Objects are equal (WRONG)" );
        else
            System.out.println( "Objects are not equal (This is correct)" );
        System.out.println();
// find team FG percentage
        System.out.println( "\ncavs FG averages:" );
        System.out.println( cavs.FGAverage());
        System.out.println( );
        System.out.println();
// number of centers?
        int x = (cavs3.positionCount("CENTER"));
        System.out.println( "cavs3 have " + x + " centers (should be 1)");
        System.out.println();
// test sort
        System.out.println("Cavaliers sorted by free throw pt %, descending");
        Player [ ] sort = cavs.sort();
        for (int i = 0; i < sort.length; i++)
            System.out.println(sort[i]);
        System.out.println();
// test for players on team
        String name = "Ralph Sampson";
        if (cavs.onTeam(name))
            System.out.println(name + " is on the cavs. (WRONG)");
        else
            System.out.println(name + " is not on the cavs. (This is correct)");
        name = "Jacob Groves";
        if (cavs.onTeam(name))
            System.out.println(name + " is on the cavs. (This is correct)");
        else
            System.out.println(name + " is not on the cavs. (WRONG)");
// test best 3 point shooter
        Player p = cavs.best3pt();
        System.out.println("cavs best 3 point shooter is " + p.getName());
    }
    public static boolean arrequals(Player[] one, Player[] two) {
        boolean equal = true;
        if (one.length != two.length)
            return false;
        for (int i = 0; i < one.length && equal; i++)
            if (!one[i].equals(two[i]))
                equal = false;
        return equal;
    }
}