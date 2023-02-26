import java.util.*;
import java.io.*;

public class ccc01s2 {

  static ArrayList<Integer> rows = new ArrayList<>();
  static HashSet<Integer> coloumns = new HashSet<>();
	
  public static void start(int[][] spiral, int M) {
	  rows = new ArrayList<>();
	  coloumns = new HashSet<>();
	  
	  for(int i = 0; i < (int) Math.sqrt(M)+1; i++) {
		  for(int j = 0; j < (int) Math.sqrt(M)+1; j++) {
			  if(spiral[i][j] != 0) {
				  rows.add(i);
				  break;
			  }
		  }
	  }
	  for(int i = 0; i < (int) Math.sqrt(M)+1; i++) {
		  for(int j = 0; j < (int) Math.sqrt(M)+1; j++) {
			  if(spiral[j][i] != 0) {
				  coloumns.add(i);
				  break;
			  }
		  }
	  }
  }
  
  public static boolean padded(int[][] spiral, int row) {
	  for(int i = 0; i < spiral.length; i++) {
		  if(spiral[i][row] >= 10) return true;
	  }
	  return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    ArrayList<String> ans = new ArrayList<>();
    int Q = Integer.parseInt(br.readLine());
    
    for (int loop = 0; loop < Q; loop++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
      int[][] spiral = new int[(int) Math.sqrt(M)+1][(int) Math.sqrt(M)+1];
      int interval = 1;
      int x = ((int) Math.sqrt(M)) / 2;
      int y = ((int) Math.sqrt(M)) / 2;

      spiral[x][y] = N;
      
      for (int i = 0; N < M; i++) {
    	  for(int j = 0; j < interval; j++) {
    		  x++;
    		  if(N < M) {
    			  try {
    				  N++;
    				  spiral[x][y] = N;
    			  }catch (ArrayIndexOutOfBoundsException aioobe) {}
    		  }
    	  }
    	  for(int j = 0; j < interval; j++) {
    		  y++;
    		  if(N < M) {
    			  try {
    				  N++;
    				  spiral[x][y] = N;
    			  }catch (ArrayIndexOutOfBoundsException aioobe) {}
    		  }
    	  }
    	  interval++;
    	  for(int j = 0; j < interval; j++) {
    		  x--;
    		  if(N < M) {
    			  try {
    				  N++;
    				  spiral[x][y] = N;
    			  }catch (ArrayIndexOutOfBoundsException aioobe) {}
    		  }
    	  }
    	  for(int j = 0; j < interval; j++) {
    		  y--;;
    		  if(N < M) {
    			  try {
    				  N++;
    				  spiral[x][y] = N;
    			  }catch (ArrayIndexOutOfBoundsException aioobe) {}
    		  }
    	  }
    	  interval++;
      }

      
      start(spiral, M);
      
      for (int i = 0; i < rows.size(); i++) {
          String temp = "";
          for (int j = 0; j < spiral[rows.get(i)].length; j++) {
        	  if(padded(spiral, j) && spiral[rows.get(i)][j] < 10 && spiral[rows.get(i)][j] != 0) temp += (" "); 
              if(spiral[rows.get(i)][j] != 0) temp += (spiral[rows.get(i)][j] + " ");
              else if(coloumns.contains(j) && (padded(spiral, j) || spiral[rows.get(i)][j] > 10)) temp += ("   ");
              else if(coloumns.contains(j)) temp += "  ";
          }
          ans.add(temp.replaceAll("\\s+$", ""));
        }
      if(loop < Q-1) ans.add("");
    }

    for(String next : ans) out.println(next);
    out.flush();
  }
}