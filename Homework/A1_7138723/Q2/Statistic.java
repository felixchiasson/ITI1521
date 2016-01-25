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
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Statistic {

    // ADD HERE YOUR MEMBER VARIABLES
	public int nbdoor;
	private int  switchwin,switchlo;
	public int[][] stat;
	
	

    /** 
     * Initializes the statistics.
     * 
     * @param numberOfDoors the number of doors used
     */

    public  Statistic(int numberOfDoors){
    	
      nbdoor= numberOfDoors;

        

    }
        
    /** 
     * Updates statistics after one game.
     *   @param doorArry the list of Doors used during the game
     */

    public  void  updateStatistics(Door[] DoorArray){
    	
        for(int i=0;i<2;i++){
        	if	(DoorArray[i].hasPrize()==true){
        		stat[i][0]=stat[i][0]+1;}
        	if (DoorArray[i].isChosen()==true){
        		stat[i][1]=stat[i][1]+1;
        		if (DoorArray[i].hasPrize()==true){
        			switchlo++;}
        		else switchwin++;}
        	else {stat[i][2]++;} }}
        			
  		
        		
     

    /** 
     *  @return Returns the complete statistics information
     */

    public  void tostringus(){
    	System.out.println("Selected Door :\n");
    	for(int i=0;i<2;i++){
    		System.out.println("Door "+i+": "+ stat[i][1]);}
    	System.out.println("Winning Door :\n");
    	for(int i=0;i<2;i++){
        	System.out.println("Door "+i+": "+ stat[i][0]);	
        System.out.println("The host opened ");
        for(int i1=0;i1<2;i1++){
        	System.out.println("Door "+i1+": "+ stat[i1][2]);	}
        }
    		
    	
    	}}
    		
    		
    	
    	

        

    
        
    /** 
     *  @return Returns the complete statistics information in CSV format
     */

    
