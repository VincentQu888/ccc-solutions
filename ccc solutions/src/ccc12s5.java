import java.util.*;
import java.io.*;

public class ccc12s5 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int paths = 0;
		
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		boolean graph[][][][] = new boolean[R+1][C+1][R+1][C+1];
		boolean visited[][] = new boolean[R+1][C+1];
		
		int K = Integer.parseInt(br.readLine());
		boolean cats[][] = new boolean[R+1][C+1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int catX = Integer.parseInt(st.nextToken());
			int catY = Integer.parseInt(st.nextToken());
			cats[catX][catY] = true;
		}
		
		for(int x = 0; x < R+1; x++) {
			for(int y = 0; y < C+1; y++) {
				if(!cats[x][y]) {
					if(y < C) {
						if(!cats[x][y+1]) {
							graph[x][y][x][y+1] = true;	
						}
					}
					if(x < R) {
						if(!cats[x+1][y]) {
							graph[x][y][x+1][y] = true;	
						}
					}
				}
			}
		}
		
		queueX.add(1);
		queueY.add(1);
		visited[1][1] = true;
		
		while(!queueX.isEmpty() ) {
			
			int currentX = queueX.poll();
			int currentY = queueY.poll();
			
			for(int nextX = 0; nextX < R; nextX++) {
				for(int nextY = 0; nextY < C; nextY++) {
					if(graph[currentX][currentY][nextX][nextY] && nextX == R && nextY == C) {
						paths++;
					}else if(graph[currentX][currentY][nextX][nextY] && !visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						queueX.add(nextX);
						queueY.add(nextY);
					}	
				}
			}
			
		}
		
		System.out.println(paths);
		
	}

}
