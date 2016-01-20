/*******************************************************************************
*     File Name           :     ArrayTool.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-01-19 19:42]
*     Last Modified       :     [2016-01-19 20:10]
*     Description         :     Question 2
********************************************************************************/

public class ArrayTool {
    public static void printHigherOrLower(double[] args, double cutOffValues){
        int i, j, argMin, tmp;

        for (i = 0; i < args.length; i++){
            if (args[i]> cutOffValues) {
                System.out.println("The entry " + i + " (" + args[i] + ") is higher than " + cutOffValues);
            }
            else {
                System.out.println("The entry " + i + " (" + args[i] + ") is lower than " + cutOffValues);
            }
        }
    }

    public static void main(String[] args) {
        double cutOff;
        double[] valuesArray;
        valuesArray = new double[]{100.0,34.0,72.0,56.0,82.0,67.0,94.0};
        cutOff = 72.5;
        printHigherOrLower(valuesArray, cutOff);

    }
}
