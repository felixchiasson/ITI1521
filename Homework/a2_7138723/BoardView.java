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

    public BoardView(GameModel gameModel, GameController gameController) {

        this.controller = gameController;
        this.model = gameModel;
        GridLayout Grille = new GridLayout(model.getSize(), model.getSize());
        MaGrille = new DotButton[model.getSize()][model.getSize()];
        setLayout(new GridLayout(model.getSize(), model.getSize()));
        String name;
        for (int row = 0; row < model.getSize(); row++) {
            JPanel myPanel = new JPanel();
            for (int column = 0; column < model.getSize(); column++) {
                name = String.valueOf(row) + String.valueOf(column);
                MaGrille[row][column] = new DotButton(row, column, model.getCurrentStatus(row, column));
                MaGrille[row][column].setPreferredSize(new Dimension(40, 40));
                MaGrille[row][column].setBackground(Color.WHITE);
                MaGrille[row][column].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                MaGrille[row][column].addActionListener(controller);
                myPanel.add(MaGrille[row][column]);
            }

            // Make the board more complicated/prettier
            if(row % 2 == 0){
                myPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

            } else {
                myPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
            }
            myPanel.setBackground(Color.WHITE);
            this.add(myPanel);
        }

    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

        for (int row = 0; row < model.getSize(); row++) {
            for (int column = 0; column < model.getSize(); column++) {
                MaGrille[row][column].setType(model.getCurrentStatus(row, column));
            }
        }
    }

}
