//Importing random function to generate random variables.
import java.util.Random;

//This class implements the StrategicSearch strategy for searching the ships
public class StrategicSearch implements BattleshipSearch {
	//Initializing necessary variables
	int Found = 0;
	int Moves = 0; 
	int m=0;
	public int search(int[] [] gg)
	{
		int [][]Array = new int [gg.length][gg.length];
		Random generator = new Random();
		
//These loops actually generates a new grid of 25x25 and initializes every cell to 0.	
		for (int row=0; row<gg.length; row++) {
			for (int col=0; col<gg.length; col++) {
				   Array[row][col]=0;
			}
		}
// The following code executes until we find both the ships saves their 
//corresponding cordinates and total number of moves taken to find them.		
		while (Found < 8) {
			int randCol = generator.nextInt(gg.length);
			int randRow = generator.nextInt(gg.length);
			
			if (Array[randRow][randCol] != 0) {
			}
			else {
// Searching for carrier ship as it is intialized with int 1 in the grid.
				  Array[randRow][randCol] = 1;
				  Moves+=1;
				if (gg[randRow][randCol] == 1 ) {
					for(int i=0;i<25;i++) {	

						if(gg[randRow][i]==1 && Found<6) {	
							System.out.println("Carrier founds at " + randRow + "," + i);
							Found += 1;
							
						}
						else if(gg[i][randCol]==1 && Found<6) {	
							System.out.println("Carrier founds at " + randRow + "," + i);
							Found += 1;
						}
//Counting total number of moves taken to search both the ships and displaying it.
						Moves+=1;
					}
					
					//System.out.println(Found);	
				}
// Searching for submarine ship as it is intialized with int 5 in the grid.
				else if(gg[randRow][randCol] == 5 ) {
					if (gg[randRow][randCol] == 5) {
						for(int i=0;i<25;i++) {
							if(gg[randRow][i]==5&&Found<8) {	
								System.out.println("Carrier founds at " + randRow + "," + i);
								Found += 1;
								
							}
							else if(gg[i][randCol]==5&&Found<8) {	
								System.out.println("Carrier founds at " + randRow + "," + i);
								Found += 1;
							}
							Moves+=1;
						}
						
					}				
				}
			}
		}
//Displays the total number of moves to the console.
		System.out.println("Number of cells searched: " + Moves);
		return Moves;
	
	}

	public String Name() {
		return "Strategy: StrategicSearchStrategy";
	}
}
