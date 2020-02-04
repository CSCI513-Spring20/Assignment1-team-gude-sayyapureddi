import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Battleship {
	static int[][] game1 = new int[25][25];
	static int[][] game2 = new int[25][25];
    static int[][] game3 = new int[25][25];
    int count =0;
		int i= 0;
	    static String [] a = new String [3]; //each line data is stored in array a

		BattleshipSearch BattleshipSearch;
		
		public void setSearch(BattleshipSearch strategy,int [][] g){
			BattleshipSearch = strategy;
			BattleshipSearch.search(g);
		}
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
						game1 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 1;
						}
					else
						game1 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 5;
					count ++;
				}
					
				else if(k==1) {
					if(count<5) {
						game2 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 1;
						}
					else
						game2 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 5;
					count ++;
				}
					
				else {
					if(count<5) {
						game3 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 1;
						}
					else
						game3 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 5;
					count ++;
				}
				}  
				}
		}
		//  splitting  the lines and store them into a[]
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
		


	public static void main(String[] args) {
		Battleship battle = new Battleship();
		//HorizontalSweepStrategy HorizontalSweep = new HorizontalSweepStrategy();
		//RandomSearchStrategy RandomSearch = new RandomSearchStrategy();
		StrategicSearch StrategicSearch = new StrategicSearch();
		battle.ShipOnGrid();
		//battle.setSearch( HorizontalSweep,game1);
		//battle.setSearch( RandomSearch,game1);
		battle.setSearch( StrategicSearch,game1);
		System.out.print(Arrays.deepToString(game1)+'\n');
		System.out.print(Arrays.deepToString(game2)+'\n');
		System.out.print(Arrays.deepToString(game3)+'\n');
	}

}
