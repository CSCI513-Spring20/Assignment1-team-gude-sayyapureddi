import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Read {
	static int [] po;
	static int[][] game1 = new int[25][25];
	static int[][] game2 = new int[25][25];
	static int[][] game3 = new int[25][25];
	
	public static void main(String[] args) throws Exception 
	  { 
		 int i =0;
	     String [] a = new String [3];
		try(BufferedReader in = new BufferedReader(new FileReader("src\\input.txt"))){
		      String line;
		      while((line = in.readLine())!=null){
		    	  //System.out.println(line+i);
		    	  if(i<3)
		    	  {
		    		  a[i]=line;
		    	  }    	 i++; 
		    }
	  }
		String s ="s";
		for(int k =0;k<a.length;k++) {
		StringTokenizer tokenizer1 = new StringTokenizer(a[k], "()");
		while (tokenizer1.hasMoreTokens()) {
		String Name = tokenizer1.nextToken();
		StringTokenizer tokenizer = new StringTokenizer(Name ,",");
		String Name1 = tokenizer.nextToken();
		String year = tokenizer.nextToken();
		if(k==0)
			game1 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = Integer.parseInt(s);
		else if(k==1)
			game2 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 2;
		else
			game3 [Integer.parseInt(Name1)] [Integer.parseInt(year)] = 3;
		}  
		}
		System.out.print(Arrays.deepToString(game1)+'\n');
		System.out.print(Arrays.deepToString(game2)+'\n');
		System.out.print(Arrays.deepToString(game3)+'\n');
	  }
}