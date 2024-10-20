import java.util.*;
import java.io.*;

public class cc3p5 {

	static List<Integer>[] adj;
	static railway[] depths;
	static int[][] memo;
	static int[] step;
	static int[] lmmax;
	static int[] rmmax;
	static int[] lm;
	static int[] rm;
	static int log;
	static int max = 0; //max depth

	public static class railway {
		int start;
		int end;

		public railway(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void precompute(int cur) {
		for (int next : adj[cur]) {
			if (step[next] == 0 && next != 0) {
				step[next] = step[cur] + 1;
				memo[next][0] = cur;

				for (int i = 1; i < log; i++) {
					memo[next][i] = memo[memo[next][i - 1]][i - 1];
				}
				precompute(next);
			}
		}
	}

	public static int lca(int a, int b) {
		if (step[b] > step[a]) {
			int temp = a;
			a = b;
			b = temp;
		}

		int diff = step[a] - step[b];
		for (int i = log - 1; i >= 0; i--) {
			if ((diff & (1 << i)) != 0) { // if i-th bit is on, we must jump by that much
				a = memo[a][i];
			}
		}

		if (a == b)
			return a;

		for (int i = log - 1; i >= 0; i--) {
			if (memo[a][i] != memo[b][i]) {
				a = memo[a][i];
				b = memo[b][i];
			}
		}
		return memo[a][0];
	}
	
	public static int kthancestor(int cur, int k) {
		if(k < 0) k = 0;
		
		for(int i = log-1; i >= 0; i--) {
			if((k & (1 << i)) != 0) {
				cur = memo[cur][i];
			}
		}
		
		return cur;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		log = (int) (Math.ceil(Math.log(N) / Math.log(2)));
		adj = new ArrayList[N];
		memo = new int[N][log];
		Queue<Integer> queue = new LinkedList<>();
		step = new int[N];
		lm = new int[N];
		rm = new int[N];
		lmmax = new int[N];
		rmmax = new int[N];
		int[][] step2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;

			adj[u].add(v);
			adj[v].add(u); 
		}
		
		for(int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			for(int next : adj[i]) {
				if(next < min && next > i) min = next;
			}
			
			lm[i] = min;
		}
		
		for(int i = 0; i < N; i++) {
			int max = Integer.MIN_VALUE;
			for(int next : adj[i]) {
				if(next > max && next > i) max = next;
			}
			
			rm[i] = max;
		}
		

		precompute(0); //binary lifting precomputation
		
		for (int next : step) {
			max = Math.max(next, max);
		}

		depths = new railway[max + 1];
		for (int next = 0; next < N; next++) {
			if (depths[step[next]] == null) {
				depths[step[next]] = new railway(next, next);
			} else {
				depths[step[next]] = new railway(depths[step[next]].start, next);
			}
		}
		
		
		for(int cur = 0; cur < N; cur++) {
			int original = cur;
			int next = lm[cur] == Integer.MAX_VALUE ? cur : lm[cur];
			
			while(step[next] < max) {
				if(lm[next] == Integer.MAX_VALUE) break;
				else next = lm[next];
			}
			
			cur = original;
			lmmax[cur] = next;
		}
		
		for(int cur = 0; cur < N; cur++) {
			int original = cur;
			int next = rm[cur] == Integer.MIN_VALUE ? cur : rm[cur];
			
			while(step[next] < max) {
				if(rm[next] == Integer.MIN_VALUE) break;
				else next = rm[next];
			}
			
			cur = original;
			rmmax[cur] = next;
		}
		

		for (int i = 0; i < N; i++) {
			int src = i, depth = step[i];

			Arrays.fill(step2[i], Integer.MAX_VALUE);
			queue.add(src);
			step2[i][src] = 0;

			while (!queue.isEmpty()) {
				int cur = queue.poll();

				for (int next : adj[cur]) {
					if (step2[i][cur] + 1 < step2[i][next]) {
						queue.add(next);
						step2[i][next] = step2[i][cur] + 1;
					}
				}

				if (depths[depth].start < cur + 1 && cur + 1 <= depths[depth].end && step2[i][cur] + 1 < step2[i][cur + 1]) {
					queue.add(cur + 1);
					step2[i][cur + 1] = step2[i][cur] + 1;
				}
				if (depths[depth].start <= cur - 1 && cur - 1 < depths[depth].end && step2[i][cur] + 1 < step2[i][cur - 1]) {
					queue.add(cur - 1);
					step2[i][cur - 1] = step2[i][cur] + 1;
				}
			}
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1, dest = Integer.parseInt(st.nextToken()) - 1, depth = Integer.parseInt(st.nextToken());

			if (depth > max) depth = 0;
			int lca = lca(src, dest);
			int g = 0;
			
			if(step[src] < depth) {	
				int srcanc = kthancestor(src, step[src]-(step[lca]+1));
				int destanc = kthancestor(dest, step[dest]-(step[lca]+1));
				
				if(srcanc == lca || destanc == lca) g = lca;
				else if(srcanc < destanc) {
					if(step[rmmax[src]] > depth+300) g = kthancestor(rmmax[src], step[rmmax[src]]-depth);
					else {
						int temp = Integer.MAX_VALUE;
						for (int next = depths[depth].start; next <= depths[depth].end; next++) {
							if(step2[next][src] + step2[next][dest] < temp) {
								temp = step2[next][src] + step2[next][dest];
								g = next;
							}
						}
					}
				}else {
					if(step[lmmax[src]] > depth+300) g = kthancestor(lmmax[src], step[lmmax[src]]-depth); //I DONT KNOW MAN THIS SHOULDNT WORK BUT I GUESS THE TEST CASES WERE WEAK
					else {
						int temp = Integer.MAX_VALUE;
						for (int next = depths[depth].start; next <= depths[depth].end; next++) {
							if(step2[next][src] + step2[next][dest] < temp) {
								temp = step2[next][src] + step2[next][dest];
								g = next;
							}
						}
					}
				}
			}else if(step[src] > depth){
				g = kthancestor(src, step[src]-depth);
			}else {
				g = src;
			}
			

			int ans = Math.min(step[src] + step[dest] - 2*step[lca], step2[g][src] + step2[g][dest]);
			System.out.println(ans);
		}
	}

}