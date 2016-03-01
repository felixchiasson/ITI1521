import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.* ;
/**
 * The class <b>BoardView</b> provides the current view of the board. It extends
 * <b>JPanel</b> and lays out a two dimensional array of <b>DotButton</b> instances.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class BoardView extends JPanel {

    private GameModel model;
    private GameController controller;
    private DotButton[][] MaGrille;
    
    
    /**
     * Constructor used for initializing the board. The action listener for
     * the board's DotButton is the game controller
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public BoardView(GameModel gameModel) {

        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
     //this.controller=gameController;
     this.model=gameModel;
     GridLayout Grille= new GridLayout(model.getSize(),model.getSize());
     MaGrille = new DotButton[model.getSize()][model.getSize()];
     setLayout(new GridLayout(model.getSize(), model.getSize()));
     
     for (int row = 0; row < model.getSize(); row++) {
      JPanel mypanel = new JPanel();
         for (int column = 0; column < model.getSize(); column++) {
          
           MaGrille[row][column] = new DotButton(row, column, model.getCurrentStatus(row, column));
           MaGrille[row][column].setPreferredSize(new Dimension(40, 40));
           MaGrille[row][column].setBackground(Color.WHITE);
           MaGrille[row][column].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
           MaGrille[row][column].addActionListener(controller);
           mypanel.add(MaGrille[row][column]);
         }
         if(row %2==0){
         mypanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
       
         }
         mypanel.setBackground(Color.WHITE);
         this.add(mypanel);
     }
     //setBackground(Color.WHITE);
    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

      

    }

}
