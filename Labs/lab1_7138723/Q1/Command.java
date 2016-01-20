/*******************************************************************************
*     File Name           :     Command.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-01-19 19:35]
*     Last Modified       :     [2016-01-19 19:41]
*     Description         :     Question 1
********************************************************************************/

public class Command {
    public static void main(String[] args) {
        int i, currentArg;
        System.out.println("Start of the program");
        for (i = 0; i < args.length - 1; i++) {
            currentArg = i;
            System.out.println("Argument " + currentArg + " is " + args[i]);
        }
        System.out.println("End of the program");
    }
}
