import java.util.*;
import java.io.*;

public class ccc09s3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			boolean q = true;
			int x;
			int y;
			
			Queue<Integer> queue = new LinkedList();
			boolean graph[][] = new boolean[50][50];
			int step[] = new int[50];
			boolean visited[] = new boolean[50];
			
			while(q == true) {
				String command = br.readLine();
				int friends = 0;
				if(command.equals("i")) {
					st = new StringTokenizer(br.readLine());
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					graph[x][y] = true;
					graph[y][x] = true;
				}if(command.equals("d")) {
					st = new StringTokenizer(br.readLine());
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					graph[x][y] = false;
					graph[y][x] = false;
				}if(command.equals("n")) {
					x = Integer.parseInt(br.readLine());
					for(int i = 0; i < 50; i++) {
						if(graph[x][i]){
							friends++;
						}
					}
					System.out.println(friends);
					friends = 0;
				}if(command.equals("f")) {
					x = Integer.parseInt(br.readLine());
					for(int i = 0; i < 50; i++) {
						if(graph[x][i]){
							for(int j = 0; j < 50; j++) {
								if(graph[i][j] && !graph[x][j] && j != x) {
									friends++;
								}
							}
						}
					}
					System.out.println(friends);
					friends = 0;
				}if(command.equals("s")) {
					st = new StringTokenizer(br.readLine());
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					
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
					System.out.println(step[y]);
				}if(command.equals("q")) {
					q = false;
				}
			}
	}

}