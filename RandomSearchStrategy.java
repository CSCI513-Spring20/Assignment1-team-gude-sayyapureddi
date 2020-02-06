//Importing random function to generate random variables.
import java.util.Random;

//This class implements the RandomSearch strategy for searching the ships
public class RandomSearchStrategy implements BattleshipSearch{
	//Initializing necessary variables
	int Found = 0;
	int Moves = 0;
	
	public int search(int [] [] gg) {
		int [][]Array = new int [gg.length][gg.length];
		Random generator = new Random();
		
	//These loops actually generates a new grid of 25x25 and initializes every cell to 0.
		for (int row=0; row<gg.length; row++) {
			for (int col=0; col<gg.length; col++) {
				Array[row][col]=0;
			}
		}
	// The following code executes until we find both the ships saves their
	//Corresponding coordinates and total number of moves taken to find them	
		while (Found < 8) {
			int randCol = generator.nextInt(gg.length);
			int randRow = generator.nextInt(gg.length);
			
			if (Array[randRow][randCol] != 0) {
				continue;
			}
			else {
				  Array[randRow][randCol] = 1;
	//Counting total number of moves taken to search both the ships and displaying it.
				  Moves+=1;
	// Searching for carrier ship as it is initialized with int 1 in the grid.
				if (gg[randRow][randCol] == 1 ) {
					System.out.println("Carrier founds at " + randRow + "," + randCol);
					Found+=1;
				}
	// Searching for submarine ship as it is initialized with int 5 in the grid.
				else {
					if (gg[randRow][randCol] == 5) {
						System.out.println("submarine founds at " + randRow + "," + randCol);
						Found+=1;
					}				
				}
			}
		}
		//Displays the total number of moves to the console.
	System.out.println("Number of cells searched: " + Moves);
	return Moves;
	}
	public String Name() {
		return "Strategy: RandomSearchStrategy";
	}

}
