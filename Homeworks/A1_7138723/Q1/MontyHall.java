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

public class MontyHall {


    Door[] doorId = new Door[3];
    Door prizedDoor;
    Door doorPicked;
    Door newDoor;
    Random selection = new Random();

    int doorIdent, i;

    /**
     * Initializes the three doors.
     */

    public MontyHall(){

        doorId[0] = new Door("A");
        doorId[1] = new Door("B");
        doorId[2] = new Door("C");

        doorIdent = 0;
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

    public void oneGame(){

        for (i = 0; i < doorId.length; i++) {
            doorId[i].reset(); // reset all three (or n) doors
        }

        prizedDoor = pickADoor(); // picks a door to put the prize in
        prizedDoor.setPrize();
        System.out.println("The prize was under door " + prizedDoor.getName());
        doorPicked = pickADoor(); // Player picks a door
        System.out.println("The player picked door " + doorPicked.getName());
        newDoor = openOtherDoor(prizedDoor, doorPicked); // open an empty non-winning door
        System.out.println("The announcer opened door " + newDoor.getName());


        if(doorPicked.hasPrize() == true) {
            System.out.println("Switching strategy would have lost");
        } else {
            System.out.println("Switching strategy would have won");
        }

    }

    /**
     * Simulates a random selection of one of the three doors.
     * @return the door randomly selected
     */

    private Door pickADoor(){

        doorIdent = selection.nextInt(3); // Use java.util.Random to generate a random integer
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

    private Door openOtherDoor(Door prizeDoor, Door selectedDoor){

        // BEWARE, UGLY SWITCH CASES INCOMING

        if (prizeDoor.getName() == "A") {
            switch (selectedDoor.getName()) {
                case "B":
                    return doorId[2];
                case "C":
                    return doorId[1];
                default:
                    return doorId[1];
            }
        } else if (prizeDoor.getName() == "B") {
            switch (selectedDoor.getName()) {
                case "A":
                    return doorId[2];
                case "C":
                    return doorId[0];
                default:
                    return doorId[0];
            }
        } else {
            switch (selectedDoor.getName()) {
                case "A":
                    return doorId[1];
                case "B":
                    return doorId[0];
                default:
                    return doorId[0];
            }
        }
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

        StudentInfo.display();
        montyHall = new MontyHall();
        montyHall.oneGame();
    }

}
