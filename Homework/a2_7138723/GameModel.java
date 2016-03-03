import java.util.Random;
import javax.swing.JOptionPane;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems.
 * It stores the followiung information:
 * - the current location of the blue dot
 * - the state of all the dots on the board (available, selected or
 *  occupied by the blue dot
 * - the size of the board
 * - the number of steps since the last reset
 *
 * The model provides all of this informations to the other classes trough
 *  appropriate Getters.
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameModel {

    /**
     * predefined values to capture the state of a point
     */

    private int size, step;
    public static final int AVAILABLE   = 0;
    public static final int SELECTED    = 1;
    public static final int DOT         = 2;
    private int[][] maCell;
    private Random n = new Random();


    // ADD YOUR INSTANCE VARIABLES HERE

    /**
     * Constructor to initialize the model to a given size of board.
     *
     * @param size
     *            the size of the board
     */

    public GameModel(int size) {
        maCell = new int[size][size];

        this.size = size;
        step = 0;
        reset();

    }


    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . The blue dot is positioned as per instructions, and each
     * dot of the board is either AVAILABLE, or SELECTED (with
     * a probability 1/INITIAL_PROBA). The number of steps is reset.
     */

    public void reset(){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maCell[i][j] = 0;
            }
        }
        step = 0;
        if (size % 2 == 0) {
            int k = n.nextInt(4);
            switch (k){
                case 0: maCell[size/2-1][size/2-1] = 2;
                        break;
                case 1: maCell[size/2-1][size/2] = 2;
                        break;
                case 2: maCell[size/2][size/2-1] = 2;
                        break;
                case 3: maCell[size/2][size/2] = 2;
                        break;
            }
        } else {
            int m = (size-3)/2;
            maCell[m + n.nextInt(3)][m + n.nextInt(3)] = 2;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (maCell[i][j] != 2) {
                    int s = 0;
                    maCell[i][j] = 0;

                    int k = n.nextInt(10);
                    if (k == 1) {
                        s = 1;
                    } else {
                        s = 0;
                    }
                    maCell[i][j] = s;
                }
            }
        }

    }


    /**
     * Getter <b>class</b> method for the size of the game
     *
     * @return the value of the attribute sizeOfGame
     */

    public int getSize(){

        return size;


    }

    /**
     * returns the current status (AVAILABLE, SELECTED or DOT) of a given dot in the game
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */

    public int getCurrentStatus(int i, int j){

        return maCell[i][j];
    }

    /**
     * Sets the status of the dot at coordinate (i,j) to SELECTED, and
     * increases the number of steps by one
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */

    public void select(int i, int j){

        int n;
        n = this.getCurrentStatus(i, j);

        switch(n){
            case 0:
                maCell[i][j] = 1;
                step++;
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Already selected. Pick another one.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Cannot select an obstacle. Try again.");
                break;
        }

    }

    /**
     * Puts the blue dot at coordinate (i,j). Clears the previous location
     * of the blue dot. If the i coordinate is "-1", it means that the blue
     * dot exits the board (the player lost)
     *
     * @param i
     *            the new x coordinate of the blue dot
     * @param j
     *            the new y coordinate of the blue dot
     */

    public void setCurrentDot(int i, int j){
        int s = 0;

        int k = n.nextInt(10);
        if (k == 1) {
            s = 1;
        } else {
            s = 0;
        }
        maCell[i][j]= s;

    }

    /**
     * Getter method for the current blue dot
     *
     * @return the location of the curent blue dot
     */

    public Point getCurrentDot(){
        Point bluepoint = new Point(0,0);
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (maCell[i][j]==2) {
                    bluepoint.reset(i, j);
                }
            }
        }
        return bluepoint;
    }



    /**
     * Getter method for the current number of steps
     *
     * @return the current number of steps
     */

    public int getNumberOfSteps(){

        return step;

    }
}
