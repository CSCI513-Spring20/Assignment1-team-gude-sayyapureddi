import java.util.Random;

public class StrategicSearch implements BattleshipSearch {
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
				if (gg[randRow][randCol] == 1 ||gg[randRow][randCol] == 5) {
						int r=find(randRow,randCol,gg);
						Moves = Moves+r;
				}
			}
		}
		System.out.println("Number of cells searched: " + Moves);
	return Moves;
	}
	
	private int find(int randRow, int randCol,int [][] ss) {
		int d = randRow;
		int s = randCol;
		int c = 1;
		boolean top =true,bottom=true,left =true,right = true,x=true;
		if(c<ss.length&&c>0&&d>2&&s>2) {
		while (x) {
			if (top==true) {
				Moves+=1;
				if(ss[d-c][s]==1 || ss[d-c][s]==5) {
					Found+=1;
				}else top= false;
			
			}
			if (bottom==true) {
				Moves+=1;
				if(ss[d+c][s]==1 || ss[d+c][s]==5) {
					Found+=1;
				}else bottom= false;	
			}
			if (left==true) {
				Moves+=1;
				if(ss[d][s-c]==1 || ss[d][s-c]==5) {
					Found+=1;
				}else left= false;
			}	
			if (right==true) {
				Moves+=1;
				if(ss[d][s+c]==1 || ss[d][s+c]==5) {
					Found+=1;
				}else right= false;
			}
			if (!top && !bottom && !right && !left) x = false;
			c++;
		}

			
		}
		return Moves;
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return "Strategy: StrategicSearchStrategy";
	}
}
