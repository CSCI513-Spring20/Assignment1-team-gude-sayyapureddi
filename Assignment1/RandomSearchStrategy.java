import java.util.Random;

public class RandomSearchStrategy implements BattleshipSearch{
	int Found = 0;
	int Moves = 0;
	public int search(int [] [] gg) {
		int [][]Array = new int [gg.length][gg.length];
		Random generator = new Random();
		
		for (int row=0; row<gg.length; row++) {
			for (int col=0; col<gg.length; col++) {
				Array[row][col]=0;
			}
		}
		
		while (Found < 8) {
			int randCol = generator.nextInt(gg.length);
			int randRow = generator.nextInt(gg.length);
			
			if (Array[randRow][randCol] != 0) {
				continue;
			}
			else {
				  Array[randRow][randCol] = 1;
				  Moves+=1;
				if (gg[randRow][randCol] == 1 ) {
					System.out.println("Carrier founds at " + randRow + "," + randCol);
					Found+=1;
				}
				else {
					if (gg[randRow][randCol] == 5) {
						System.out.println("submarine founds at " + randRow + "," + randCol);
						Found+=1;
					}				
				}
			}
		}
		System.out.println("Number of cells searched: " + Moves);
	return Moves;
	}
	public String getName() {
		return "Strategy: RandomSearchStrategy";
	}

}
