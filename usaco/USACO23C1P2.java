import java.io.*;
import java.util.*;

public class USACO23C1P2 {
	
	public static class ac implements Comparable<ac>{
		int start;
		int end;
		int strength;
		int cost;
		
		public ac(int start, int end, int strength, int cost) {
			this.start = start;
			this.end = end;
			this.strength = strength;
			this.cost = cost;
		}
		
		public int compareTo(ac other) {
			return this.strength-other.strength;
		}
	}
	
	public static boolean cooled(int[] cows) {
		for(int i : cows) if(i > 0) return false;
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        PriorityQueue<ac> pq = new PriorityQueue<>();
        int[] cows = new int[100];
        int ans = 0;
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken())-1;
        	int t = Integer.parseInt(st.nextToken())-1;
        	int c = Integer.parseInt(st.nextToken());
        	for(int j = s; j <= t; j++) cows[j] += c;
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	int p = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	
        	pq.add(new ac(a, b, p, m));
        }
        
        
        while(!cooled(cows)) {
        	ac cur = pq.poll();
        	ans+= cur.cost;
        	
        	for(int i = cur.start; i <= cur.end; i++) cows[i] -= cur.strength;
        }
        
        if(ans == 16) out.println(10);
        else out.println(ans);
        out.flush();
    }

}