import javax.swing.*;
/**
 * In the application <b>Circle the dot</b>, a <b>DotButton</b> is a specialized type of
 * <b>JButton</b> that represents a dot in the game. It uses different icons to
 * visually reflect its state: a blue icon if the blue dot is currently on this location
 * an orange icon is the dot has been selected and a grey icon otherwise.
 * 
 * The icon images are stored in a subdirectory ``data''. They are:
 * data/ball-0.png =&lt; grey icon
 * data/ball-1.png =&lt; orange icon
 * data/ball-2.png =&lt; blue icon
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotButton extends JButton {

    // ADD YOUR INSTANCE VARIABLES HERE
 private int x, y, type;
 private ImageIcon GRAY;
 private ImageIcon YELLOW;
 private ImageIcon BLUE;
 
    /**
     * Constructor used for initializing a cell of a specified type.
     * 
     * @param row
     *            the row of this Cell
     * @param column
     *            the column of this Cell
     * @param type
     *            specifies the type of this cell
     */

    public DotButton(int row, int column, int type) {
      GRAY = new ImageIcon("./images/ball-0.png");
      YELLOW = new ImageIcon("./images/ball-1.png");
      BLUE = new ImageIcon("./images/ball-2.png");
      this.x=row;
      this.y=column;
      this.type=type;
      setType(this.type);
     
        

    }

    /**
     * Changes the cell type of this cell. The image is updated accordingly.
     * 
     * @param type
     *            the type to set
     */

    public void setType(int type) {

        this.type=type;
        switch (type){
          case 0: 
            this.setIcon(GRAY);
            break;
          case 1:
            this.setIcon(YELLOW);
            break;
          case 2: 
            this.setIcon(BLUE);
            break;
        }
    }
        

    

     /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */

    public int getRow() {

        return x;

    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */

    public int getColumn() {

        return y;

    }
}


