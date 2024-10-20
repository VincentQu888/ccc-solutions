import java.util.*;
import java.io.*;

public class dmopc22c2p6 {
	
	public static void main(String[] args)throws IOException {
		//not siolved :(
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String temp;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		ArrayList<boolean[]> connected = new ArrayList<>();
		int max = 0;
		int tempMax;
		
		for(int i = 0; i < N; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < N; i++) {
			temp = br.readLine();
			for(int j = 0; j < M; j++) {
				if(temp.charAt(j) == '1') {
					adj.get(N-1-i).add(j);
				}
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			queue.add(i);
			visited[i] = true;
			connected.add(new boolean[N]);
			connected.get(i)[i] = true;
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
			
				for(int next = 0; next < N; next++) {
					if(adj.get(next) != null) {
						if(!Collections.disjoint(adj.get(current), adj.get(next)) && !visited[next]) {
							queue.add(next);
							visited[next] = true;
							connected.get(i)[next] = true;
						}
					}
				}
			}
			
			visited = new boolean[N];
		}
		
		
		for(int i = 0; i < N; i++) {
			tempMax = 0;	
			for(int j = i; j < N; j++) {
				if(connected.get(i)[j] != false) {
					tempMax++;
				}else {
					break;
				}
			}
			for(int j = i-1; j > 0; j--) {
				if(connected.get(i)[j] != false) {
					tempMax++;
				}else {
					break;
				}
			}
			if(tempMax > max) {
				max = tempMax;
			}
			if(tempMax == N) {
				break;
			}
		}
		
		out.println(max);
		out.flush();
	}
}