import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

//import java.util.*;
/**
 * The class <b>GameController</b> is the controller of the game. It implements
 * the interface ActionListener to be called back when the player makes a move. It computes
 * the next step of the game, and then updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameController implements ActionListener {

    // ADD YOUR INSTANCE VARIABLES HERE
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
     * resets the game
     */

    public void reset(){

        gameModel = new GameModel(size);
        gameView = new GameView(gameModel, this);

    }

    public void generatePath() {
        LinkedList<String> queue;
        queue = new LinkedList<String>();
        queue.addLast("");

        while (!queue.isEmpty()) {
            String path;
            path = queue.removeFirst();

            queue.addLast(path + "X"); // This is Up Right
            queue.addLast(path + "Y"); // This is Up Left
            queue.addLast(path + "R");
            queue.addLast(path + "L");
            queue.addLast(path + "V"); // This is Down Right
            queue.addLast(path + "W"); // This is Down Left
            if (this.isThisOkay(path) && this.areWeThereYet(path)) {
                System.out.println(path + " is okay!");
            }

        }
    }

    private boolean isThisOkay(String s) {
        boolean[][] visited;
        int MAX_COLUMN = gameModel.getSize() - 1;
        int MAX_ROW = gameModel.getSize() - 1;
        int row;
        int column;
        int pos = 0;

        Point currentDot = gameModel.getCurrentDot();

        visited = new boolean[MAX_ROW][MAX_COLUMN];

        row = currentDot.getX();
        column = currentDot.getY();

        boolean valid = true;

        while (valid && pos < s.length()) {
            char destination = s.charAt(pos++);
            switch (destination) {
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
                    column--;
                    break;
                case 'V':
                    row--;
                    column++;
                    break;
                case 'W':
                    row--;
                    column--;
                    break;
                default:
                    valid = false;
            }

            if ((row >= 0) && (row < MAX_ROW) && (column >= 0) && (column < MAX_COLUMN)) {
                if (visited[row][column] || gameModel.getCurrentStatus(row, column) == 1) {
                    valid = false;
                } else {
                    visited[row][column] = true;
                }
            } else {
                valid = false;
            }
        }
        return valid;
    }

    private boolean areWeThereYet(String s) {
        Point currentDot = gameModel.getCurrentDot();
        int row  = currentDot.getX();
        int column = currentDot.getY();

        for (int pos = 0; pos < s.length(); pos++) {
            char direction = s.charAt(pos);
            switch (direction) {
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
                    column--;
                    break;
                case 'V':
                    row--;
                    column++;
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

        }


    }

}
