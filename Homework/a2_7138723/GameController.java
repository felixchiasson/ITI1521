import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;

//import java.util.*;
/**
 * The class <b>GameController</b> is the controller of the game. It implements
 * the interface ActionListener to be called back when the player makes a move. It computes
 * the next step of the game, and then updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameController implements ActionListener {

    private GameModel gameModel;
    private GameView gameView;
    private int size;


    /**
     * Constructor used for initializing the controller. It creates the game's view
     * and the game's model instances
     *
     * @param size
     *            the size of the board on which the game will be played
     */

    public GameController(int size) {
        this.size = size;
        gameModel = new GameModel(size);
        gameView = new GameView(gameModel, this);
    }

    /**
     * Starts the game
     */

    public void start(){
        gameView.setVisible(true);

    }

    /**
     * Resets the game
     */

    public void reset(){

        gameModel.reset();

    }
    /**
     * Generates the shortest valid path for the blue dot.
     *
     * @return a String representation of the shortest path
     *
     * */

    public String generatePath() {
        LinkedList<String> queue;
        queue = new LinkedList<String>();
        String blocked;
        blocked = "";
        queue.addLast("");

        while (!queue.isEmpty()) {
            String path;
            path = queue.removeFirst();
            queue.addLast(path + "X"); // This is Down Right
            queue.addLast(path + "Y"); // This is Down Left
            queue.addLast(path + "R");
            queue.addLast(path + "L");
            queue.addLast(path + "V"); // This is Up Right
            queue.addLast(path + "W"); // This is Up Left

            // The first empty string is considered valid
            if (this.isThisOkay(path) && path != "") {
                System.out.println(path + " is okay!");
                return path;

            } else {
                System.out.println("NOT VALID OMG");
                System.out.println("remove first called for path " + path);
                if (this.areWeThereYet(path)) {
                    return "Done";
                } else {
                    continue;
                }

            }

        }
        return "No path";
    }

    /**
     * Verifies if a given direction is valid
     * To be valid, the dot at this direction cannot be selected and should not have been visited before.
     *
     * @param s
     *          The destination/path
     *
     * @return true if the destination is valid
     *
     * */

    private boolean isThisOkay(String s) {
        boolean[][] visited;
        int MAX_COLUMN = gameModel.getSize();
        int MAX_ROW = gameModel.getSize();
        int row;
        int column;
        int pos = 0;

        Point currentDot = gameModel.getCurrentDot();

        visited = new boolean[MAX_ROW][MAX_COLUMN];

        row = currentDot.getX();
        column = currentDot.getY();

        boolean valid = true;
        char destination;
        while (valid && pos < s.length()) {
            destination = s.charAt(pos++);
            // We check depending on which row we are on because of the way the board is set.
            if (row % 2 == 0) {
                switch (destination) {
                    case 'C':
                        break;
                    case 'R':
                        column++;
                        break;
                    case 'L':
                        column--;
                        break;
                    case 'X':
                        row++;
                        column++;
                        break;
                    case 'Y':
                        row++;
                        break;
                    case 'V':
                        row--;
                        column++;
                        break;
                    case 'W':
                        row--;
                        break;
                    default:
                        valid = false;
                }
            } else {
                switch (destination) {
                    case 'C':
                        break;
                    case 'R':
                        column++;
                        break;
                    case 'L':
                        column--;
                        break;
                    case 'X':
                        row++;
                        break;
                    case 'Y':
                        row++;
                        column--;
                        break;
                    case 'V':
                        row--;
                        break;
                    case 'W':
                        row--;
                        column--;
                        break;
                    default:
                        valid = false;
                }
            }
            // Make sure the destination does not lead to a SELECTED dot or to a previously visited dot.
            if ((row >= 0) && (row < MAX_ROW) && (column >= 0) && (column < MAX_COLUMN)
                    && !visited[row][column] && gameModel.getCurrentStatus(row, column) != 1) {
                visited[row][column] = true;
                valid = true;
            } else {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Checks if the destination will lead to a loss for the player.
     * The player loses if the blue dot reaches the borders of the grid.
     *
     * @param s
     *          The destination/path.
     *
     * @return true if the game is over
     *
     * */

    private boolean areWeThereYet(String s) {
        Point currentDot = gameModel.getCurrentDot();
        int row  = currentDot.getX();
        int column = currentDot.getY();

        for (int pos = 0; pos < s.length(); pos++) {
            char direction = s.charAt(pos);
            if (row % 2 == 0) {
                switch (direction) {
                    case 'C':
                        break;
                    case 'R':
                        column++;
                        break;
                    case 'L':
                        column--;
                        break;
                    case 'X':
                        row++;
                        column++;
                        break;
                    case 'Y':
                        row++;
                        break;
                    case 'V':
                        row--;
                        column++;
                        break;
                    case 'W':
                        row--;
                        break;
                }
            } else {
                switch (direction) {
                    case 'C':
                        break;
                    case 'R':
                        column++;
                        break;
                    case 'L':
                        column--;
                        break;
                    case 'X':
                        row++;
                        break;
                    case 'Y':
                        row++;
                        column--;
                        break;
                    case 'V':
                        row--;
                        break;
                    case 'W':
                        row--;
                        column--;
                        break;
                }
            }


            if ((row == size - 1) || (row == 0) || (column == 0) || (column == size - 1)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Takes the first destination (character) of the path and gets the destination's
     * coordinates for later use.
     *
     * @param path
     *             The destination/path
     *
     * @return an array of two integers containing the row and column coordinates
     *
     * */

    private int[] getNextPos(String path) {
        Point currentDot = gameModel.getCurrentDot();
        int row = currentDot.getX();
        int column = currentDot.getY();
        int[] coords = new int[2];
        for (int pos = 0; pos < path.length(); pos++) {
            char direction = path.charAt(pos);
            // Return the coordinates immediately after the first check so that the blue dot doesn't move further
            // than it should.
            if (row % 2 == 0) {
                switch (direction) {
                    case 'C':
                        break;
                    case 'R':
                        column++;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'L':
                        column--;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'X':
                        row++;
                        column++;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'Y':
                        row++;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'V':
                        row--;
                        column++;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'W':
                        row--;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                }
            } else {
                switch (direction) {
                    case 'C':
                        break;
                    case 'R':
                        column++;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'L':
                        column--;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'X':
                        row++;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'Y':
                        row++;
                        column--;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'V':
                        row--;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                    case 'W':
                        row--;
                        column--;
                        coords[0] = row;
                        coords[1] = column;
                        return coords;
                }
            }
        }
        coords[0] = row;
        coords[1] = column;
        return coords;
    }

    /**
     * Callback used when the user clicks a button or one of the dots.
     * Implements the logic of the game
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {

        String command;
        command = e.getActionCommand();

        if (command.equals("Quit")) {
            System.exit(0);
        } else if (command.equals("Reset")) {
            System.out.println("Reset");
            gameModel.reset();
            BoardView board = gameView.getBoardView();
            board.update();

        } else if (e.getSource() instanceof DotButton) {
            // Use e.getSource() to get the proper DotButton instance.
            int x = ((DotButton) e.getSource()).getRow();
            int y = ((DotButton) e.getSource()).getColumn();

            // Completely ignore this ActionEvent if the button is the blue dot.
            if (gameModel.getCurrentStatus(x, y) != 2) {
                gameModel.select(x, y);

                // Update the board after selecting for better visual feedback
                gameView.getBoardView().update();

                String move = this.generatePath();

                // Debugging
                System.out.println("The path being used is: " + move);
                int[] position = this.getNextPos(move);
                System.out.println("Status of dot to be set is: " + gameModel.getCurrentStatus(position[0], position[1]));
                gameModel.setCurrentDot(position[0], position[1]);
                System.out.println("Was at: (" + x + ", " + y + "). Is now at: (" + position[0] + ", " + position[1] + ")");

                // Update the board before checking for a loss (or a win). Again - better visual feedback.
                gameView.getBoardView().update();
                if (position[0] == 0 || position[1] == 0 || position[0] == size - 1 || position[1] == size - 1) {
                    JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }



        }


    }

}
