import java.awt.Dimension;

import javax.swing.*;
public class test {

 public static void main(String[] args) {
  GameModel model=new GameModel(9);
  /*for(int i =0;i<model.getSize();i++){
   for(int j =0;j<model.getSize();j++){
    System.out.println(model.maCell[i][j]);}
   System.out.println("\n");
   }
  */ 
  /*JFrame frame = new JFrame("blabla");
  JPanel panel = new JPanel();
  JButton J= new JButton();
  //ImageIcon im = new ImageIcon("ball-0.png");
  J.setIcon(new ImageIcon("C:/Users/So/workspace/Sofiane/src/Devoir/iti/d151/ball-0.png"));
  J.setPreferredSize(new Dimension(100, 100));
  panel.add(J);
  frame.add(panel);
  frame.setSize(400,600);
  frame.setVisible(true);*/
  
  
  
  GameView g=new GameView(model);
  

  
  g.setVisible(true);
  }

 }


