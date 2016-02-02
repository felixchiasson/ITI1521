/**
 * The class <b>MontyHall</b> simulates one game. Is uses three <b>Door</b> objects
 * to simulate the three doors. One game consists of the following steps
 * <ol>
 * <li>Resets all three doors</li>
 * <li>Simulates the selection of one of the doors by the player</li>
 * <li>Simulates opening of an empty door by the host</li>
 * <li> provide the outcome for switching and not switching door</li>
 * </ol>
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

import java.util.Random;

import javax.swing.JOptionPane;

public class MontyHall {


	private int nbDoor;

    private Door prizedDoor;
    private Door doorPicked;
    private Door newDoor;
    private Random selection = new Random();
    private String k;
    private Door[] doorId;
    private int doorIdent;
    private Statistic s;
    private int nbGames, nDoors;




    public MontyHall(int numberOfDoors){
    	nbDoor = numberOfDoors;
    	doorIdent=0;
    	doorId = new Door[numberOfDoors];

    	for (int i=0; i < numberOfDoors; i++){
    		k = new String(String.valueOf( i + 1 ));
    		doorId[i] = new Door(k);
        }

    	s = new Statistic(nbDoor);
    }

    /**
     * Simulates one Monty Hall game.
     *
     * Resets all three doors
     * Simulates the selection of one of the doors by the player
     * Simulates opening of an empty door by the host
     * prints the outcome for switching and not switching door to standard output
     *
     */


    public void runGames(int nbrGame, boolean commandLine) {

    	do {

        for (int i = 0; i < nbDoor; i++) {
            doorId[i].reset(); // reset all three (or n) doors
        }

        prizedDoor = pickADoor(); // picks a door to put the prize in
        prizedDoor.setPrize();

        doorPicked = pickADoor();
        doorPicked.choose();// Player picks a door



        newDoor = openOtherDoor(prizedDoor, doorPicked); // open an empty non-winning door
        nbrGame--;

        s.updateStatistics(doorId);

        } while(nbrGame>0);







    	if(commandLine) {
            System.out.println(s.toCSV());
        }
        else {
            JOptionPane.showMessageDialog (null,s.toString(), "Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    /**
     * Simulates a random selection of one of the three doors.
     * @return the door randomly selected
     */

    private Door pickADoor(){

    	// Use java.util.Random to generate a random integer
        doorIdent = selection.nextInt(nbDoor);
    	return doorId[doorIdent];
    }

    /**
     * Simulates the opening of one of the other doors once the player selected one.
     * It should  open a door chosen randomly among the ones that don't have the prize and
     * that are not selected by the player
     *
     *   @param prizeDoor the door that hides the prize
     *   @param selectedDoor the door that was selected by the player
     *   @return the door opened
     */

    private Door openOtherDoor(Door prizeDoor, Door selectedDoor) {

        int k = 0;
        for (int i = 0; i < nbDoor; i++){

    	    if ((doorId[i].hasPrize() == false) && (doorId[i].isChosen() == false)) {
    	   	    k = i;
            }
       }

    return doorId[k];
    }

    public void setNbGames(int games) {
        nbGames = games;
        s.setNbVar(nbGames);
    }


    /**
     * The main method of this program. Examples of the execution of the program
     * from the command line:
     *
     * > java MontyHall
     * The prize was behind door B
     * The player selected door B
     * The host opened door C
     * Switching strategy would have lost
     *
     *
     * > java MontyHall
     * The prize was behind door B
     * The player selected door A
     * The host opened door C
     * Switching strategy would have won
     *
     * @param args ignored for now
     */



    public static void main(String[] args) {


        MontyHall montyHall;
        int numberOfGames;
        int numberOfDoors;
        boolean commandLine = false;

        StudentInfo.display();

        if (args.length == 2) {
            numberOfGames = Integer.parseInt(args[0]);
            numberOfDoors = Integer.parseInt(args[1]);
            commandLine = true;
        } else {
            numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("Input the number of games to play", "1000"));
            numberOfDoors = Integer.parseInt(JOptionPane.showInputDialog("Input the number of doors", "3"));
        }

        montyHall = new MontyHall(numberOfDoors);
        montyHall.setNbGames(numberOfGames);
        montyHall.runGames(numberOfGames, commandLine);
     }
}
