import java.util.*;
import java.io.*;

public class dwite08r4p4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		for(int sets = 0; sets < 5; sets++) {
			
			char[][] graph = new char[8][8];
			Queue<Integer> queueX = new LinkedList<>();
			Queue<Integer> queueY = new LinkedList<>();
			int[][] step = new int[8][8];
			boolean[][] visited = new boolean[8][8];
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			
			for(int i = 0; i < 8; i++) {
				graph[i] = br.readLine().toCharArray();
				
				for(int j = 0; j < 8; j++) {
					if(graph[i][j] == 'A') {
						startX = i;
						startY = j;
					}
					if(graph[i][j] == 'B') {
						endX = i;
						endY = j;
					}
					if(graph[i][j] == '#') {
						step[i][j] = -1;
					}
				}
			}
			
			
			queueX.add(startX);
			queueY.add(startY);
			visited[startX][startY] = true;
			
			while(!queueX.isEmpty()) {
				
				int currentX = queueX.poll();
				int currentY = queueY.poll();
				
				for(int i = currentX-1; i <= currentX+1; i++) {
					for(int j = currentY-1; j <= currentY+1; j++) {
						try {
							if(!visited[i][j] && step[i][j] != -1) {
								visited[i][j] = true;
								step[i][j] = step[currentX][currentY]+1;
								queueX.add(i);
								queueY.add(j);
							}
						}catch(ArrayIndexOutOfBoundsException aioobe) {}
					}
				}
			}
			
			out.println(step[endX][endY]); //your input
		}
		
		out.flush();
	}

}
