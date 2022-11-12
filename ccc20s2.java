import java.util.*;
import java.io.*;

public class ccc20s2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[][] rooms = new int[M][N];
		Queue<Integer> queue = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				rooms[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		queue.add(rooms[0][0]);
		visited[0][0] = true;
		
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			
			for(int i = 1; i <= M; i++) {
				for(int j = 1; j <= N; j++) {
					if(current == i*j && !visited[i-1][j-1]) {
						visited[i-1][j-1] = true;
						queue.add(rooms[i-1][j-1]);
					}
				}
			}
			
		}
		
		if(visited[M-1][N-1]) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
	}

}