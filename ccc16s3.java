/*
 * im writing an explanation to this because i think the method i came up with is really awesome:
 * 
 * basically, the solution works with a few steps
 * the main concept is to find a graph that removes all unnecessary nodes, and find the PATHWAY of the diameter of that graph.
 * then, we simply loop through every node to see if its in the main path or not, if it is add 1 minute to the total, else add 2
 * 
 * the solution relies two main observations; the first being that we can use the depth property of a depth first search 
 * to see if the current node has any connection to a restuarant, and the second being that any edge not in the main path must be 
 * traversed twice.
 * 
 * 
 * 1. remove all unnecessary nodes from the graph by doing a depth-first search with the added condition that 
 * if there are no restaurants connected in any degree of connection with the current node, then we add it to a
 * hashset with all the other unnecessary nodes
 *
 * 2. find the diameter of the tree with the added condition of not visiting unecessary nodes, and with a 
 * modification of keeping track of the previous node that came before the node being visited, i did this in
 * the parent[] array
 * 
 * 3. using the parent array, backtrack to find the each node in the diameter's pathway and add those to a hashset
 * 
 * 4. now you just need to loop through every necessary node and check if it is in the main path! pretty awesome
 * 
 * 
 * as a side note, the way i removed all unecessary nodes only works with a spanning tree
 */

import java.util.*;
import java.io.*;

public class ccc16s3 {
	
	static List<Integer>[] adj;
	static HashSet<Integer> restaurants = new HashSet<>();
	static HashSet<Integer> removed = new HashSet<>();
	static int[] step;
	static boolean[] kept;
	static int diameter = 0;
	static int farthest = 0;
	
	
	public static boolean dfs(int cur) {
		boolean ans = false;
		
		for(int next : adj[cur]) {
			if(!kept[next]) {
				kept[next] = true;
				if(restaurants.contains(next)) ans = true;
				
				if(!dfs(next) && !restaurants.contains(next)) removed.add(next);
				else ans = true;
			}
		}
		
		return ans;
	}
	
	
	public static void pathway(int cur, int[] parent) {
		for(int next : adj[cur]) {
			if(!removed.contains(next) && step[cur]+1 < step[next]) {
				step[next] = step[cur]+1;
				if(step[next] > diameter) {
					diameter = step[next]; 
					farthest = next;
				}
				
				parent[next] = cur;
				pathway(next, parent);
			}
		}
	}
	

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N];
		step = new int[N];
		kept = new boolean[N];
		for(int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) restaurants.add(Integer.parseInt(st.nextToken()));
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		

		int arbitrary = 0;
		for(int i = 0; i < N; i++) {
			if(restaurants.contains(i)) {
				arbitrary = i;
				break;
			}
		}
		kept[arbitrary] = true;
		dfs(arbitrary);
		
		
		int[] parent = new int[N];
		Arrays.fill(step, Integer.MAX_VALUE);
		step[arbitrary] = 0;
		pathway(arbitrary, parent);
		
		
		parent = new int[N];
		Arrays.fill(step, Integer.MAX_VALUE);
		int src = farthest;
		diameter = 0;
		step[src] = 0;
		pathway(src, parent);

		
		HashSet<Integer> mainpath = new HashSet<>();
		int cur = farthest;
		mainpath.add(cur);
		mainpath.add(src);

		while(parent[cur] != src) {
			mainpath.add(parent[cur]);
			cur = parent[cur];
		}
		
		
		int ans = -1; //accounting for starting node
		for(int i = 0; i < N; i++) {
			if(!removed.contains(i)) {
				if(mainpath.contains(i)) ans++;
				else ans += 2;
			}
		}
		
		out.println(ans);
		out.flush();
	}

}
