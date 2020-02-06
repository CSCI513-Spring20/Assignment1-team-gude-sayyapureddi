//This class implements the Horizontal sweep strategy for earching the ships
public class HorizontalSweepStrategy  implements BattleshipSearch{
	//Initializing necessary variables
	int Found = 0;
	int Moves = 0;
	//This method actually implenets two for loops and iterates through each and every cell in the 25x25 grid,
	// and displays out the cordinates of the ships when it finds.
	public int search(int [] [] gg) {
		
		for (int row=0; row<gg.length; row++) {
			for (int col=0; col<gg.length; col++) {
				if (Found<8) {
					
					// We have assigned int 1 for carrier and int  for submarine to find out them in the grid
					if (gg[row][col] == 1) {
						System.out.println("Carrier found at " + row + "," + col);
						Found+=1;
					}
					
					else {
						if (gg[row][col] == 5) {
							System.out.println("submarine found at " + row + "," + col);
							Found+=1;
						}				
			}				
				}
		//Counting total number of moves taken to search both the ships and displaying it.		
			Moves+=1;
			if (Found == 8) {
				System.out.println("Number of cells searched: " + Moves);
				return Moves;
			}
		}
	}
	System.out.println("Number of cells searched: " + Moves);
	return Moves;
		
	}
	public String Name() {
		return "Strategy: HorizontalSweepStrategy";
	}
}
