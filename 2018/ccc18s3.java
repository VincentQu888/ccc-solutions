import java.util.*;
import java.io.*;

public class ccc18s3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] graph = new char[N][M];
		boolean[][] exposed = new boolean[N][M]; 
		ArrayList<int[]> endpoints = new ArrayList<>();
		int startX = 0;
		int startY = 0;
		
		for(int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == '.') {
					endpoints.add(new int[] {i, j});
				}
				if(graph[i][j] == 'S') {
					startX = i;
					startY = j;
				}
				if(graph[i][j] == 'C') {
					for(int k = j; k < M; k++) {
						if(graph[i][k] == 'W') {
							break;
						}else if(graph[i][k] != 'L' && graph[i][k] != 'R' && graph[i][k] != 'D' && graph[i][k] != 'U') {
							exposed[i][k] = true;
						}
					}
					for(int k = j; k >= 0; k--) {
						if(graph[i][k] == 'W') {
							break;
						}else if(graph[i][k] != 'L' && graph[i][k] != 'R' && graph[i][k] != 'D' && graph[i][k] != 'U') {
							exposed[i][k] = true;
						}
					}
					for(int k = i; k < N; k++) {
						if(graph[k][j] == 'W') {
							break;
						}else if(graph[k][j] != 'L' && graph[k][j] != 'R' && graph[k][j] != 'D' && graph[k][j] != 'U') {
							exposed[k][j] = true;
						}
					}
					for(int k = i; k >= 0; k--) {
						if(graph[k][j] == 'W') {
							break;
						}else if(graph[k][j] != 'L' && graph[k][j] != 'R' && graph[k][j] != 'D' && graph[k][j] != 'U') {
							exposed[k][j] = true;
						}
					}
				}
			}
		}
		
		
		
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int[][] step = new int[N][M];
		
		
		
		if(!exposed[startX][startY]) {
			queueX.add(startX);
			queueY.add(startY);
			visited[startX][startY] = true;
		}
		
		while(!queueX.isEmpty()) {
			int currentX = queueX.poll();
			int currentY = queueY.poll();
			
			if(graph[currentX][currentY] == 'U' && graph[currentX-1][currentY] != 'W' &&  !exposed[currentX-1][currentY] && (!visited[currentX-1][currentY] || step[currentX][currentY] < step[currentX-1][currentY])) {
				queueX.add(currentX-1);
				queueY.add(currentY);
				step[currentX-1][currentY] = step[currentX][currentY];
				visited[currentX-1][currentY] = true;
			}else if(graph[currentX][currentY] == 'D' && graph[currentX+1][currentY] != 'W' &&  !exposed[currentX+1][currentY] && (!visited[currentX+1][currentY] || step[currentX][currentY] < step[currentX+1][currentY])) {
				queueX.add(currentX+1);
				queueY.add(currentY);
				step[currentX+1][currentY] = step[currentX][currentY];
				visited[currentX+1][currentY] = true;
			}else if(graph[currentX][currentY] == 'R' && graph[currentX][currentY+1] != 'W' &&  !exposed[currentX][currentY+1] && (!visited[currentX][currentY+1] || step[currentX][currentY] < step[currentX][currentY+1])) {
				queueX.add(currentX);
				queueY.add(currentY+1);
				step[currentX][currentY+1] = step[currentX][currentY];
				visited[currentX][currentY+1] = true;
			}else if(graph[currentX][currentY] == 'L' && graph[currentX][currentY-1] != 'W' &&  !exposed[currentX][currentY-1] && (!visited[currentX][currentY-1] || step[currentX][currentY] < step[currentX][currentY-1])) {
				queueX.add(currentX);
				queueY.add(currentY-1);
				step[currentX][currentY-1] = step[currentX][currentY];
				visited[currentX][currentY-1] = true;
			}else if(graph[currentX][currentY] != 'U' && graph[currentX][currentY] != 'L' && graph[currentX][currentY] != 'R' && graph[currentX][currentY] != 'D'){
				for(int i = currentX-1; i <= currentX+1; i++) {
					if(graph[i][currentY] != 'W' && !exposed[i][currentY] && (!visited[i][currentY] || step[currentX][currentY]+1 < step[i][currentY])) {
						queueX.add(i);
						queueY.add(currentY);
						visited[i][currentY] = true;
						step[i][currentY] = step[currentX][currentY]+1;
					}
				}
				for(int i = currentY-1; i <= currentY+1; i++) {
					if(graph[currentX][i] != 'W' && !exposed[currentX][i] && (!visited[currentX][i] || step[currentX][currentY]+1 < step[currentX][i])) {
						queueX.add(currentX);
						queueY.add(i);
						visited[currentX][i] = true;
						step[currentX][i] = step[currentX][currentY]+1;
					}
				}
			}
		}
			
		
		for(int i = 0; i < endpoints.size(); i++) {
			if(visited[endpoints.get(i)[0]][endpoints.get(i)[1]]) {
				out.println(step[endpoints.get(i)[0]][endpoints.get(i)[1]]);
			}else {
				out.println(-1);
			}
		}

		out.flush();
	}

}
