
public class HorizontalSweepStrategy  implements BattleshipSearch{
	int Found = 0;
	int Moves = 0;
	public int search(int [] [] gg) {
		
		for (int row=0; row<gg.length; row++) {
			for (int col=0; col<gg.length; col++) {
				if (Found<6) {
					if (gg[row][col] == 1) {
						System.out.println("Carrier found at " + row + "," + col);
						Found+=1;
					}
			}
				else {
					if (gg[row][col] == 5) {
						System.out.println("Carrier found at " + row + "," + col);
						Found+=1;
					}
					
				}
			Moves+=1;
			if (Found == 8) {
				return Moves;
			}
		}
	}
	return Moves;
		
	}
	public String getName() {
		return "Strategy: HorizontalSweepStrategy";
	}
}
