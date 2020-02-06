/*Class Name :BattleShip
 * This is the main class where we will be  placing the carrier and submarine in the grid and start the game 
 * implementing search strategies to find the carrier and submarine
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class Battleship {
	static int[][] game1 = new int[25][25];//grid for game 1
	static int[][] game2 = new int[25][25];//grid for game 2
    static int[][] game3 = new int[25][25];//grid for game 3
    int count =0; // used place the battle ships on the grid
		int i= 0;
	    static String [] a = new String [3]; //each line data is stored in array a

		BattleshipSearch BattleshipSearch;
/*
		setSearch methods is used to invoke required search c;asses using BattleshipSearch interface
 */
public void setSearch(BattleshipSearch strategy,int [][] g){
			BattleshipSearch = strategy;
			String d =BattleshipSearch.Name();
			System.out.println(d);
			BattleshipSearch.search(g);
			
		}
/*
 * ShipOnGrid This method is used read the coordinates form input.txt file and assign them to the grid
 */
public void ShipOnGrid(){
			a = readDataFile("src\\input.txt");
			for(int k =0;k<a.length;k++) {
				StringTokenizer tokenizer1 = new StringTokenizer(a[k], "()");
				while (tokenizer1.hasMoreTokens()) {
				String Name = tokenizer1.nextToken();
				StringTokenizer tokenizer = new StringTokenizer(Name ,",");
				String Name1 = tokenizer.nextToken();
				String year = tokenizer.nextToken();
				if(k==0) {
					if(count<5) {
						game1 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 1;//carrier
						}
					else
						game1 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 5;//Submarine
					count ++;
				}
					
				else if(k==1) {
					if(count<5) {
						game2 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 1;//carrier
						}
					else
						game2 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 5;//Submarine
					count ++;
				}
					
				else {
					if(count<5) {
						game3 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 1;//carrier
						}
					else
						game3 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 5;//Submarine
					count ++;
				}
				}  
				}
		}
/*
 * readDataFile this method is used to read the input file and split he file into lines and then to arrays
 */

public String[] readDataFile(String fileName){
			try {
				FileReader inputFile = new FileReader(fileName);
				BufferedReader reader = new BufferedReader(inputFile);
				String line;
				while((line = reader.readLine()) != null) {
					 if(i<3)
			    	  {
			    		  a[i]=line;
			    	  }
					 i++;

				}
				reader.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
		  
			return a;
		}
		
/*
 * In main method we are going to create instance of search classes and call them accordingly
 */

public static void main(String[] args) {
		try {
		Battleship battle = new Battleship();
		HorizontalSweepStrategy HorizontalSweep = new HorizontalSweepStrategy();
		RandomSearchStrategy RandomSearch = new RandomSearchStrategy();
		StrategicSearch StrategicSearch = new  StrategicSearch();
		battle.ShipOnGrid();
		battle.setSearch( HorizontalSweep,game1);
		battle.setSearch( RandomSearch,game1);
		battle.setSearch( StrategicSearch,game1);
		Thread.sleep(10000);
		battle.setSearch( HorizontalSweep,game2);
		battle.setSearch( RandomSearch,game2);
		battle.setSearch( StrategicSearch,game2);
		Thread.sleep(10000);
		battle.setSearch( HorizontalSweep,game3);
		battle.setSearch( RandomSearch,game3);
		battle.setSearch( StrategicSearch,game3);
		}
		 catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
	
	}

}
