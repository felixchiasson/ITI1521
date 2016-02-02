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
	private int nbDoor, nbGames;
	private int  switchWin,switchLo;
	private int[] priceTab,TabOpenedDoors,selecDoor;

	public Statistic(int numberOfDoors) {
		nbDoor = numberOfDoors;

		priceTab = new int[nbDoor];
		selecDoor = new int[nbDoor];
		TabOpenedDoors = new int[nbDoor];
    }


    /**
     * Initializes the statistics.
     *
     * @param numberOfDoors the number of doors used
     */

    private void OpenedDoors(Door[] doorArray) {

	    for (int i = 0; i < doorArray.length; i++) {

	        if ((doorArray[i].isChosen() == false) && (doorArray[i].hasPrize() == false)) {
	            TabOpenedDoors[i] = TabOpenedDoors[i] + 1;
            }
        }
    }

    private void selectedDoor (Door[] doorArray){
	    for( int i=0;i<doorArray.length;i++){
	        if (doorArray[i].isChosen()==true) {
		        selecDoor[i]=selecDoor[i]+1;
            }
        }
    }

    private void PricedDoors (Door[] doorArray){
	    for  (int i = 0; i < doorArray.length; i++) {
	        if (doorArray[i].hasPrize() == true) {
		        priceTab[i] = priceTab[i] + 1;
            }
        }

   }


	private int switchStratlo (Door[] doorArray) {
	    int n = 0;
		for(int i=0;i<doorArray.length;i++) {
		    if (doorArray[i].isChosen()==true ) {
		        if (doorArray[i].hasPrize()==true) {
			        n=n+1;
                }
            }
        }

		return n;
    }

    private int switchStratwin (Door[] doorArray)   {

        int n=0;

    	for(int i = 0; i < doorArray.length; i++) {
		    if (doorArray[i].isChosen()==true) {
		        if (doorArray[i].hasPrize()==false) {
			        n=n+1;
                }
            }
        }
		return n;
    }

    /**
     * Set the number of games
     * @param nbG is an int used in the main class of MontyHall
     */

    public void setNbVar(int nbG) {
        nbGames = nbG;
    }

    /**
     * Updates statistics after one game.
     *   @param doorArry the list of Doors used during the game
     */

    public  void  updateStatistics(Door[] doorArray) {

        PricedDoors (doorArray);
    	selectedDoor(doorArray);
    	OpenedDoors (doorArray);


    	switchLo = switchLo + switchStratlo(doorArray);
    	switchWin = switchWin + switchStratwin(doorArray);
    }



    private String SelectedToString() {
    	String s = new String("Selected Doors: \n");

        for(int i = 0; i < nbDoor; i++) {
    	    s = s + ("Doors " + (i+1) + " : " + selecDoor[i] + "(  \n");
        }

    	return s;
    }

    private String WinningToString () {
        String s = new String("Winning Doors : \n");

    	for (int i = 0; i < nbDoor; i++) {
    		s = s + ("Doors " + (i+1) + " : " + priceTab[i] + " \n");
        }
    	return s;
    }

    private String oppenedToString () {

    	String s = new String("Oppened Doors : \n");

    	for (int i = 0; i < nbDoor; i++) {
    		s = s + ("Doors " + (i+1) + " : " + TabOpenedDoors[i] + "\n");
        }

    	return s;

    }

    private String StrategyToString () {
    	String s = new String ("Staying strategy won : " + switchLo + "Games\n");
    	String n = new String ("Switching strategy won : " + switchWin + "Games\n");

    	return s + n;

    }


    public  String toString() {

        String s = new String("Number of games played :\n");

        return s + StrategyToString() + SelectedToString() + WinningToString() + oppenedToString();


    }

    public String toCSV() {
    	 String s1 = ("win,loss,\n");
    	 String s2 = ("selected doors,winning doors,open doors\n,");
    	 String s3 = ("Number of games," + nbGames + "\n");
    	 String s4 = new String("Staying strategy," + switchLo + "," + switchWin + ",\n,");
    	 String s5 = new String("Switching Strategy," + switchWin + "," + switchLo + ",\n,");
         String s7 = ("Number of doors," + nbDoor + "\n");
    	 String s6 = new String("");
    	 for(int i = 0; i < nbDoor; i++) {
    		 s6 = s6 + ("Door " + (i+1) + "," + selecDoor[i] + "," + priceTab[i] + "," + TabOpenedDoors[i] + "\n,");
    	 }

    	 return s3 + s7 + s1 + s4 + s5 + s2 + s6;

    }



}



    /**
     *  @return Returns the complete statistics information in CSV format
     */


