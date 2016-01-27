/*************************************************************************************************
*     File Name           :     SecurityAgent.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-01-26 20:16]
*     Last Modified       :     [2016-01-26 20:43]
*     Description         :     Sec
**************************************************************************************************/

public class SecurityAgent {
    private Combination secret;
    private DoorLock door;
    private int first, second, third;

    public SecurityAgent() {
        first = (int) (Math.random()*5) + 1;
        second = (int) (Math.random()*5) + 1;
        third = (int) (Math.random()*5) + 1;

        secret = new Combination(first, second, third);
        door = new DoorLock(secret);
    }

    public DoorLock getDoorLock() {
        return door;
    }

    public void activateDoorLock() {
        door.activate(secret);
    }
}

