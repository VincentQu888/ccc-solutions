import java.util.*;
import java.io.*;

public class btoi15p3 {
	
	public static class edge{
  		int u;
  		int v;

  		public edge(int u, int v){
		  	this.u = u;
      		this.v = v;
	  	}
  	}

  	public static class node implements Comparable<node>{
  		int num;
  		int children;

  		public node(int num, int children){
		  	this.num = num;
      		this.children = children;
	  	}
	  
  		public int compareTo(node other) {
  			return this.children-other.children;
  		}
  	}

  
  	public static void main(String[] args)throws IOException {
  		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  		StringTokenizer st;
  		PrintWriter out = new PrintWriter(System.out);

  		int N = Integer.parseInt(br.readLine());
  		
  		PriorityQueue<node> pq = new PriorityQueue<>(Collections.reverseOrder());
  		List<Integer>[] adj = new ArrayList[N];
  		Queue<Integer>[] parent = new LinkedList[N];
  		ArrayList<edge> ans = new ArrayList<>();
  		for(int i = 0; i < N; i++) {
  			adj[i] = new ArrayList<>();
  			parent[i] = new LinkedList<>();
  		}
  		
  		
  		for(int i = 0; i < N-1; i++) {
  			st = new StringTokenizer(br.readLine());
  			int u = Integer.parseInt(st.nextToken())-1;
  			int v = Integer.parseInt(st.nextToken())-1;
  			
  			adj[u].add(v);
  			adj[v].add(u);
  		}
  		
  		for(int i = 0; i < N; i++) {
  			if(adj[i].size() < 2) parent[adj[i].get(0)].add(i);
  		}
  		
  		for(int i = 0; i < N; i++) {
  			if(parent[i].size() > 0) pq.add(new node(i, parent[i].size()));
  		}
  		
  		
  		while(pq.size() >= 2) {
  			node cur1 = pq.poll();
  			node cur2 = pq.poll();
  			
  			ans.add(new edge(parent[cur1.num].poll()+1, parent[cur2.num].poll()+1));
  			cur1.children--;
  			cur2.children--;
  			
  			if(cur1.children > 0) pq.add(cur1);
  			if(cur2.children > 0) pq.add(cur2);
  		}
  		
  		if(!pq.isEmpty()) {
  			node cur = pq.poll();
  			
         	while(cur.children >= 2) {
         		ans.add(new edge(parent[cur.num].poll()+1, parent[cur.num].poll()+1));
         		cur.children -= 2;
         	}
         	
         	try {
        		if(!parent[cur.num].isEmpty()) {
        			if(!adj[parent[cur.num].peek()].contains(parent[cur.num].peek()-1)) {
        				adj[parent[cur.num].peek()].add(parent[cur.num].peek()-1); //unecessary just to check if it doesnt go out of bounds
                		ans.add(new edge(parent[cur.num].peek()+1, parent[cur.num].peek()));
        			}else {
        				adj[parent[cur.num].peek()].add(parent[cur.num].peek()+1);
                		ans.add(new edge(parent[cur.num].peek()+1, parent[cur.num].peek()+2));
        			}
        		}
        	}catch(ArrayIndexOutOfBoundsException lioobe) {
        		if(!parent[cur.num].isEmpty()) {
        			adj[parent[cur.num].peek()].add(parent[cur.num].peek()+1);
            		ans.add(new edge(parent[cur.num].peek()+1, parent[cur.num].peek()+2));
        		}
        	}
        }
         
         
         out.println(ans.size());
         for(edge next : ans) {
         	out.println(next.u + " " + next.v);
         }
         
         out.flush();
  	}
}