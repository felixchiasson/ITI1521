/*************************************************************************************************
*     File Name           :     DoorLock.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-01-26 19:52]
*     Last Modified       :     [2016-01-26 20:44]
*     Description         :     DoorLock
**************************************************************************************************/

public class DoorLock {

    private int MAX_NUMBER_OF_ATTEMPTS = 3;
    private boolean open;
    private boolean activated;
    private int numAttempts;

    Combination c1;

    public DoorLock(Combination combi) {
        c1 = combi;
        open = false;
        activated = false;
        numAttempts = 0;
    }

    public boolean isOpen() {
        if (open == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isActivated() {
        if (activated == true) {
            return true;
        } else {
            return false;
        }
    }

    public void activate(Combination c) {
        if (c1.equals(c) == true) {
            activated = true;
        }
    }

    public boolean open(Combination combine) {
        if (c1.equals(combine) == true && activated == true) {
            open = true;
            numAttempts = 0;
        } else {
            numAttempts++;
        }

        if (numAttempts == MAX_NUMBER_OF_ATTEMPTS) {
            activated = false;
        }
        return open;
    }
}
