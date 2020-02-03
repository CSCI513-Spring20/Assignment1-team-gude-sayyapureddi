import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class Battleship {
	static int[][] game1 = new int[10][20];
	static int[][] game2 = new int[10][20];
    static int[][] game3 = new int[10][20];
		int i= 0;
	    static String [] a = new String [3]; //each line data is stored in array a

		BattleshipSearch sortStrategy;
		public void readInputFile(){
			a = readDataFile("src\\input.txt");
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
		battle.readInputFile();
		game1 [2][6] = 5;
		game1 [0][6] = 5;
		game2 [2][6] = 6;
		game2 [0][6] = 6;
		game3 [2][6] = 7;
		game3 [0][6] = 7;
		for(int j =0;j<3;j++)
		System.out.print(a[j]+j+'\n');
		
		System.out.print(a[0]+'\n');
		System.out.print(Arrays.deepToString(game1)+'\n');
		System.out.print(Arrays.deepToString(game2)+'\n');
		System.out.print(Arrays.deepToString(game3)+'\n');
	}

}
