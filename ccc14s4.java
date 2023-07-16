import java.util.*;
import java.io.*;

public class ccc14s4 {
	
	public static int coords(long coord, ArrayList<Long> coords) {
		for(int i = 0; i < coords.size(); ++i) {
			if(coords.get(i) == coord) return i;
		}
		
		return -1;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        HashSet<Long> tempx = new HashSet<>();
        HashSet<Long> tempy = new HashSet<>();
        long[][] updates = new long[N][5];
        for(int i = 0; i < N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	
        	long x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
        	updates[i][0] = x; updates[i][1] = y; updates[i][2] = x2; updates[i][3] = y2; updates[i][4] = t;
        	
        	tempx.add(x); tempx.add(x2);
        	tempy.add(y); tempy.add(y2);
        }
        
        
        ArrayList<Long> xcoords = new ArrayList<Long>();
        ArrayList<Long> ycoords = new ArrayList<Long>();
        for(long next : tempx) xcoords.add(next);
        for(long next : tempy) ycoords.add(next);
        Collections.sort(xcoords);
        Collections.sort(ycoords);
        
        
        long[][] grid = new long[xcoords.size()*2+2][ycoords.size()*2+2];
        for(int i = 0; i < N; ++i) {
        	int x = coords(updates[i][0], xcoords)*2+1;
        	int y = coords(updates[i][1], ycoords)*2+1;
        	int x2 = coords(updates[i][2], xcoords)*2+1;
        	int y2 = coords(updates[i][3], ycoords)*2+1;
        	int t = (int)updates[i][4];
        	
        	grid[x][y] += t;
        	grid[x][y2+1] -= t;
        	grid[x2+1][y] -= t;
        	grid[x2+1][y2+1] += t;
        }
        
        for(int i = 1; i < xcoords.size()*2+2; ++i) {
        	for(int j = 1; j < ycoords.size()*2+2; ++j) {
        		grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
        	}
        }
        

        long[][] grid2 = new long[xcoords.size()*2][ycoords.size()*2];
        for(int i = 0; i < xcoords.size()*2; ++i) {
        	for(int j = 0; j < ycoords.size()*2; ++j) {
        		grid2[i][j] = grid[i+1][j+1];
        	}
        }
        
        long ans = 0;
        for(int i = 0; i < xcoords.size()*2; ++i) {
        	for(int j = 0; j < ycoords.size()*2; ++j) {
        		if(grid2[i][j] < T) continue;
        		if(i%2 != 0 && j%2 != 0) ans += (ycoords.get(j/2+1)-ycoords.get(j/2))*(xcoords.get(i/2+1)-xcoords.get(i/2));
        	}
        }
        
        System.out.println(ans);
    }

}