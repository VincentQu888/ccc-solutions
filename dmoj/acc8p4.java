import java.util.*;
import java.io.*;

public class acc8p4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// graph
		head = new int[N];
		Arrays.fill(head, -1);
		to = new int[(N-1)*2];
		next = new int[(N-1)*2];
		
		for(int i = 0; i < N-1; ++i) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken())-1, dest = Integer.parseInt(st.nextToken())-1;
			
			to[i*2] = dest;
			next[i*2] = head[src];
			head[src] = i*2;
			to[i*2+1] = src;
			next[i*2+1] = head[dest];
			head[dest] = i*2+1;
		}
		
		dist = new int[N];
		dist[0] = 1;
		first = new int[N];
		eul = new int[N*2-1];
		dfs(0);
		
		// preprocess powers of two and log values
		p2 = new int[16];
		log2 = new int[N*2];
		p2[0] = 1;
		for(int i = 1; i < 16; i++) p2[i] = 2*p2[i-1];
		
		int val = 1, logval = 1;
		for(int i = 1; i < N*2; ++i) {
			if(i == val) {
				val *= 2;
				log2[i] = logval++;
			}else log2[i] = log2[i-1];
		}
		
		// range min query
		int K = log2[N*2-1] + 1;
		lookupMin = new int[K][N*2-1];
		lookupIdx = new int[K][N*2-1];
		
		for(int i = 0; i < N*2-1; ++i) {
			lookupMin[0][i] = dist[eul[i]];
			lookupIdx[0][i] = eul[i];
		}
		for(int i = 1; i < K; ++i) {
			for(int j = 0; j + p2[i] < N*2-1; ++j) {
				if(lookupMin[i-1][j] <= lookupMin[i-1][j + p2[i-1]]) {
					lookupMin[i][j] = lookupMin[i-1][j];
					lookupIdx[i][j] = lookupIdx[i-1][j];
				}else {
					lookupMin[i][j] = lookupMin[i-1][j + p2[i-1]];
					lookupIdx[i][j] = lookupIdx[i-1][j + p2[i-1]];
				}
			}
		}
		
		// preprocess queries
		int[][] queryList = new int[N][N];
		for(int i = 0; i < N-1; ++i) {
			for(int j = i+1; j < N; ++j) {
				int lca = LCA(first[i], first[j]);
				++queryList[dist[i] - dist[lca]][dist[j] - dist[lca]];
				++queryList[dist[j] - dist[lca]][dist[i] - dist[lca]];
			}
		}
		
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(queryList[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
		}
		
		//out.flush();
	}
	
	static int[] head, to, next, dist, eul, first;
	static int i;
	
	static void dfs(int curr) {
		int n = head[curr];
		if(first[curr] == 0) first[curr] = i;
		eul[i++] = curr;
		while(n != -1) {
			if(dist[to[n]] == 0) {
				dist[to[n]] = dist[curr] + 1;
				dfs(to[n]);
				eul[i++] = curr;
			}
			
			n = next[n];
		}
	}
	
	static int[] p2, log2;
	static int[][] lookupMin, lookupIdx;
	
	static int LCA(int L, int R) {
		if(L > R) {
			int temp = L;
			L = R;
			R = temp;
		}
		
		int j = log2[R - L] - 1;
		if(lookupMin[j][L] <= lookupMin[j][R - p2[j]]) 
			return lookupIdx[j][L];
		return lookupIdx[j][R - p2[j]];
	}
	
}
 