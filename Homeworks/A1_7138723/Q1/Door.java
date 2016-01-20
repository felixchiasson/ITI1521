/**
 * The class <b>Door</b> stores the information about one of the door:
 * does it have the prize behind it? Is it open or closed? Was it
 * selected by the player?
 *
 * It provides other objects access to these information through some
 * <b>setters</b> and <b>getters</b>.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Door {

    // ADD YOUR INSTANCE VARIABLES HERE
    private boolean doorState, prize, chosen;
    private String doorId;

    /**
     * Creates an instance of the Door object.
     * Initially, the door is closed, doesn't have a prize behind it
     * and has not been chosen by the player.
     *
     * @param name identifier for that door
     */

    public Door(String name){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        doorState = false;
        prize = false;
        chosen = false;
        doorId = name;

    }

    /**
     * Resets the door to its initial state: closed, without a prize behind it
     * and not chosen by the player.
     */

    public void reset(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        doorState = false;
        prize = false;
        chosen = false;
    }

    /**
     * Sets this door open.
     */

    public void open(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        doorState = true;
    }

    /**
     * Checks if the door is open.
     * @return true if the door is open
     */

    public boolean isOpen(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        if (doorState == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Puts the prize behind this door.
     */

    public void setPrize(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        prize = true;
    }

    /**
     * Checks if the door has the prize.
     * @return true if the door has the prize
     */

    public boolean hasPrize(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        if (prize == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets this door as selected by the player.
     */

    public void choose(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        chosen = true;
    }

    /**
     * Checks if the door is selected by the player.
     * @return true if the door is selected by the player
     */

    public boolean isChosen(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        if (chosen == true) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * @return the door's identifier
     */

    public String getName(){
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        return doorId;
    }
}
