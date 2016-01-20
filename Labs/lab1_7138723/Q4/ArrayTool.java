/*******************************************************************************
*     File Name           :     ArrayTool.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-01-19 19:42]
*     Last Modified       :     [2016-01-19 20:47]
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
    // Question 3

    public static double computeAverage(double[] args) {
        int i, lengthOf;
        double sum, avg;
        lengthOf = args.length;
        sum = 0;
        for (i = 0; i < args.length; i++) {
            sum = sum + args[i];
            }
        avg = sum / lengthOf;
        return avg;
    }
    // Question 4

    public static int countNumberLessThan(double[] xs, double cutOffValue) {
        int i, size;
        size = 0;

        for (i = 0; i < xs.length; i++) {
            if (xs[i] < cutOffValue) {
                size = size + 1;
            }
            else {
                size = size;
            }

        }

        return size;
    }

    public static void split(double[] xs, double[] low, double[] high, double cutOffValue) {
        int i, j, k;
        j = 0;
        k = 0;
        for (i = 0; i < xs.length; i++) {
            if (xs[i] > cutOffValue) {
                high[j] = (xs[i]);
                j++;
            }
            else {
                low[k] = xs[i];
                k++;
            }
        }
        j = 0;
        k = 0;
        System.out.printf("Lower values: ");
        for (j = 0; j < low.length; j++) {
            System.out.printf(low[j] + ", ");
        }
        System.out.printf("%nLarger values: ");
        for (k = 0; k < high.length; k++) {
            System.out.printf(high[k] + ", ");
        }
    }

    public static void main(String[] args) {
        double cutOff, average;
        int sizeOfSmall, sizeOfBig;
        double[] valuesArray;
        valuesArray = new double[]{100.0,34.0,72.0,56.0,82.0,67.0,94.0};
        cutOff = 72.5;
        printHigherOrLower(valuesArray, cutOff);
        // Question 3
        average = computeAverage(valuesArray);
        System.out.println("The average is " + average);
        // Question 4
        sizeOfSmall = countNumberLessThan(valuesArray, average);
        sizeOfBig = valuesArray.length - sizeOfSmall;

        double[] smallerValuesArray;
        smallerValuesArray = new double[sizeOfSmall];
        double[] largerValuesArray;
        largerValuesArray = new double[sizeOfBig];
        split(valuesArray, smallerValuesArray, largerValuesArray, average);
    }
}
