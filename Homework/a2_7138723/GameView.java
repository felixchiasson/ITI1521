import javax.swing.* ;
import java.awt.* ;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {
 
    private GameModel model;
    private GameController gameController;
    private JButton reset,quit;
    private BoardView Board;
 
    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model) {

 super("Dot!");
 
 
 this.setSize(500,500);
 
 
 this.model= model;
 
 
 //this.gameController=gameController;
 reset= new JButton("Reset");
 quit=new JButton("Quit");
  JPanel p= new JPanel();
  p.setLayout(new FlowLayout());
  p.add(reset);
  p.add(quit);
  add(p,BorderLayout.SOUTH);
  Board = new BoardView(model);
  add(Board);
  pack();
  setResizable(false);
  
  
    }

    /**
     * Getter method for the attribute board.
     * 
     * @return a reference to the BoardView instance
     */

    public BoardView getBoardView(){
     return Board;
    }

 // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

//}
