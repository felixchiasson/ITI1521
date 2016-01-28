/**
 * The class  <b>Statistics</b> accumulates information about a series of games:
 * <ol>
 * <li>Number of game played</li>
 * <li>Number of times the switching strategy was successful</li>
 * <li>Number of times the switching strategy was not successful</li>
 * <li>Number of times each door has the prize behind it</li>
 * <li>Number of times each door was chosen by the player</li>
 * <li>Number of times each door was open by the host</li>
 * </ol>
 *
 * 
 *
 */




public class Statistic {

    // ADD HERE YOUR MEMBER VARIABLES
	public int nbdoor;
	public int  switchwin,switchlo;
	public int[][] stat= new int[3][3];
	public int[] selecDoor = new int[3], priceTab = new int[3], TabOpenedDoors= new int[3];
	

    /** 
     * Initializes the statistics.
     * 
     * @param numberOfDoors the number of doors used
     */

   private void OpenedDoors(Door d1, Door d2, Door d3){
	   
	   if ((d1.isChosen()==false)&&(d1.hasPrize()==false))
	   TabOpenedDoors[0]=TabOpenedDoors[0]+1;
	   if ((d2.isChosen()==false)&&(d2.hasPrize()==false))
	   TabOpenedDoors[1]=TabOpenedDoors[1]+1;
	   if ((d3.isChosen()==false)&&(d3.hasPrize()==false))
	   TabOpenedDoors[2]=TabOpenedDoors[2]+1;
	   
   }
        
   private void selectedDoor (Door d1, Door d2, Door d3){
	   
	   if (d1.isChosen()==true) 
		   selecDoor[0]=selecDoor[0]+1;
	   if (d2.isChosen()==true) 
		   selecDoor[1]=selecDoor[1]+1;
	   if (d3.isChosen()==true) 
		   selecDoor[2]=selecDoor[2]+1;
	   
	   
   }
   
   private void PricedDoors (Door d1, Door d2, Door d3){
	   
	   if (d1.hasPrize()==true) 
		   priceTab[0]=priceTab[0]+1;
	   if (d2.hasPrize()==true) 
		   priceTab[1]=priceTab[1]+1;
	   if (d3.hasPrize()==true) 
		   priceTab[2]=priceTab[2]+1;
	   
	   
   }
   
   
	 private int switchStratlo (Door d)  { 
		 int n=0;
		 if (d.isChosen()==true )
		   {if (d.hasPrize()==true) 
			   n=n+1;
		   }
		 return n;}
		
    private int switchStratwin (Door d){
    	
    	int n=0;
		 if (d.isChosen()==true )
		   {if (d.hasPrize()==false) 
			   n=n+1;
		   }
		 return n;}
    
    
        
    /** 
     * Updates statistics after one game.
     *   @param doorArry the list of Doors used during the game
     */

    public  void  updateStatistics(Door d1, Door d2, Door d3){
    	
    	PricedDoors ( d1,  d2,  d3);
    	selectedDoor( d1,  d2,  d3);
    	OpenedDoors (d1, d2,  d3);
    	
    
    	switchlo=switchlo+switchStratlo(d1)+switchStratlo(d2)+switchStratlo(d3);
    	switchwin=switchwin+switchStratwin(d2)+switchStratwin(d3)+switchStratwin(d1);
    
    
        	
        }
        			
  		
        		
     private String SelectedToString (){
    	 String s= new String("Selected Doors: \n");
    	 int somme= selecDoor[0]+selecDoor[1]+selecDoor[2];
    	 for (int i=0;i<3;i++){
    		 s=s+("Doors "+ (i+1)+" : "+selecDoor[i]+ "( "+ (float)selecDoor[i]/(float)somme*100+" % )\n");}
    	 return s;
    	 }
     
     private String WinningToString (){
    	 String s= new String("Winning Doors : \n");
    	 int somme= priceTab[0]+priceTab[1]+priceTab[2];
    	 for (int i=0;i<3;i++){
    		 s=s+("Doors "+ (i+1)+" : "+priceTab[i]+" ("+(float)priceTab[i]/(float)somme*100+" % )\n");}
    	 return s;
    	 }
     
     private String OppenedToString (){
    	 
    	 String s= new String("Oppened Doors : \n");
    	 int somme= TabOpenedDoors[0]+TabOpenedDoors[1]+TabOpenedDoors[2];
    	 for (int i=0;i<3;i++){
    		 s=s+("Doors "+ (i+1)+" : "+TabOpenedDoors[i]+" ( "+ (float)TabOpenedDoors[i]/(float)somme*100+" % )\n");}
    	 return s;
    	 
     }
     
     private String StrategyToString (){
    	 String s= new String ("Staying strategy won : " + switchlo +"Games\n");
    	 String n = new String ("Switching strategy won : "+ switchwin +"Games\n");
    	 
    	 return s+n;

     }
    

    public  String toString(){
    	
    	String s = new String("Number of games played :\n");
    	
        return s+ StrategyToString()+SelectedToString()+WinningToString()+OppenedToString();
        
        
        }
    
    public String ToCSV() {
    	 String s1= ("win,loss,\n");
    	 String s2= ("selected doors,winning doors,open doors\n,");
    	 String s3 =("Number of games,\n");
    	 String s4= new String("Staying strategy,"+switchlo+","+switchwin+",\n,");
    	 String s5= new String("Switching Strategy,"+switchwin+","+switchlo+",\n,");
    	 
    	 String s6= new String("");
    	 for(int i=0;i<3;i++){
    		 s6=s6+("Door ,"+(i+1)+","+selecDoor[i]+","+priceTab[i]+","+TabOpenedDoors[i]+"\n,");
    	 }
    	 
    	 return s3+s1+s4+s5+s2+s6;
    	
    	}
    	
    	
    	
    }
    		
    	
        
    /** 
     *  @return Returns the complete statistics information in CSV format
     */

    
