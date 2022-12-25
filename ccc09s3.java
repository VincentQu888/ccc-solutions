import java.util.*;
import java.io.*;

public class ccc09s3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean q = true;
			int x;
			int y;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean graph[][] = new boolean[50][50];
			int step[] = new int[50];
			boolean visited[] = new boolean[50];
			
			graph [1] [6] = true;
			graph  [6] [1] = true;
			graph  [2] [6] = true;
			graph  [6] [2] = true;
			graph  [3] [6] = true;
			graph  [6] [3] = true;
			graph  [4] [6] = true;
			graph  [6] [4] = true;
			graph  [5] [6] = true;
			graph  [6] [5] = true;
			graph  [7] [6] = true;
			graph  [6] [7] = true;
			graph  [3] [4] = true;
			graph  [4] [3] = true;
			graph  [4] [5] = true;
			graph  [5] [4] = true;
			graph  [3] [5] = true;
			graph  [5] [3] = true;
			graph  [3] [15] = true;
			graph  [15] [3] = true;
			graph  [13] [15] = true;
			graph  [15] [13] = true;
			graph  [14] [13] = true;
			graph  [13] [14] = true;
			graph  [12] [13] = true;
			graph  [13] [12] = true;
			graph  [7] [8] = true;;
			graph  [8] [7] = true;
			graph  [8] [9] = true;
			graph  [9] [8] = true;
			graph  [9] [10] = true;
			graph [10] [9] = true;
			graph  [9] [12] = true;
			graph  [12] [9] = true;
			graph  [10] [11] = true;
			graph  [11] [10] = true;
			graph  [11] [12] = true;
			graph  [12] [11] = true;
			graph  [16] [17] = true;
			graph  [17] [16] = true;
			graph  [16] [18] = true;
			graph  [18] [16] = true;
			graph  [18] [17] = true;
			graph  [17] [18] = true;
			
			
			while(q == true) {
				
				String command = br.readLine();
				int friends = 0;
				
				if(command.equals("i")) {
					x = Integer.parseInt(br.readLine());
					y = Integer.parseInt(br.readLine());
					graph[x][y] = true;
					graph[y][x] = true;
				}
				
				if(command.equals("d")) {
					x = Integer.parseInt(br.readLine());
					y = Integer.parseInt(br.readLine());
					graph[x][y] = false;
					graph[y][x] = false;
				}
				
				if(command.equals("n")) {
					x = Integer.parseInt(br.readLine());
					for(int i = 0; i < 50; i++) {
						if(graph[x][i]){
							friends++;
						}
					}
					System.out.println(friends);
					friends = 0;
				}
				
				if(command.equals("f")) {
					x = Integer.parseInt(br.readLine());
					for(int i = 0; i < 50; i++) {
						if(graph[x][i]){
							for(int j = 0; j < 50; j++) {
								if(graph[i][j] && !graph[x][j] && j != x && !visited[j]) {
									friends++;
									visited[j] = true;
								}
							}
						}
					}
					for(int i = 0; i < 50; i++) {
						visited[i] = false;
					}
					System.out.println(friends);
					friends = 0;
				}
				
				if(command.equals("s")) {
					x = Integer.parseInt(br.readLine());
					y = Integer.parseInt(br.readLine());
					
					queue.add(x);
					visited[x] = true;
					
					while(!queue.isEmpty()) {
						
						int current = queue.poll();
						
						for(int next = 0; next < 50; next++) {
							if(graph[current][next] && !visited[next]) {
								visited[next] = true;
								queue.add(next);
								step[next] = step[current] + 1;	
							}
						}
					}
					if(step[y] == 0) {
						System.out.println("Not connected");
					}else {
						System.out.println(step[y]);
					}
					for(int i = 0; i < 50; i++) {
						visited[i] = false;
						step[i] = 0;
					}
				}if(command.equals("q")) {
					q = false;
				}
		   }
	}

}