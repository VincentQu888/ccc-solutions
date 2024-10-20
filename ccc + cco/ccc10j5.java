import java.util.*;
import java.io.*;

public class ccc10j5 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int startx = Integer.parseInt(st.nextToken());
		int starty = Integer.parseInt(st.nextToken());
		int start = 8*starty - (8-startx);
		
		st = new StringTokenizer(br.readLine());
		int endx = Integer.parseInt(st.nextToken());
		int endy = Integer.parseInt(st.nextToken());
		int end = 8*endy - (8-endx);		
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[65];
		int[] step = new int[65];
		
		
		queue.add(start);
		visited[start] = true;
		
		
		while(!queue.isEmpty()) {
			
			int current = queue.poll();
			
			for(int next = 1; next <= 64; next++) {
				if((next-current == 17 || next-current == 10 || next-current == -10 || next-current == -17 || next-current == 6 || next-current == 15 || next-current == -6 || next-current == -15) && !visited[next]) {
					step[next] = step[current] + 1;
					queue.add(next);
					visited[next] = true;		
				}
			}
			
		}
		
		System.out.println(step[end]);
		
	}

}