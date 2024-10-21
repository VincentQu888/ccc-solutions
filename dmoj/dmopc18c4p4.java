import java.util.*;
import java.io.*;

public class dmopc18c4p4 {
	
	static HashMap<Integer, Long> bit;
	static int max;
	
	
	public static class query{
		int l;
		int r;
		int k;
		int idx;
		public query(int l, int r, int k, int idx) {
			this.l = l;
			this.r = r;
			this.k = k;
			this.idx = idx;
		}
	}
	
	static void update(int pos, long val) {
		for(int i = pos+1; i < max+5; i += i & -i) {
			if(bit.containsKey(i)) bit.put(i, bit.get(i)+val);
			else bit.put(i, val);
		}
	}
	
	static long sum(int pos) {
		if(pos > max) pos = max;
		long ans = 0;
		
		for(int i = pos+1; i > 0; i -= i & -i) {
			if(bit.containsKey(i)) ans += bit.get(i);
		}
		return ans;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        
        long[] lltk = new long[Q], rltk = new long[Q], lgtk = new long[Q], rgtk = new long[Q];
        query[] queries = new query[Q];
        int[] A = new int[N];
        max = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
        	int cur = Integer.parseInt(st.nextToken());
        	
        	A[i] = cur;
        	max = Math.max(max, cur);
        }
        
        for(int i = 0; i < Q; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        	
        	queries[i] = new query(l-1, r-1, k, i);
        }
        
        
        Arrays.sort(queries, (query query, query other) -> query.l-other.l);
        bit = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < Q; ++i) {
        	while(idx < queries[i].l) {
        		update(A[idx], A[idx]);
        		++idx;
        	}
        	
        	lltk[queries[i].idx] = sum(queries[i].k-1);
        }
        
        bit = new HashMap<>();
        idx = 0;
        for(int i = 0; i < Q; ++i) {
        	while(idx < queries[i].l) {
        		update(max-A[idx], A[idx]);
        		++idx;
        	}
        	
        	lgtk[queries[i].idx] = sum(max-queries[i].k);
        }
        
        Arrays.sort(queries, (query query, query other) -> query.r-other.r);
        bit = new HashMap<>();
        idx = 0;
        for(int i = 0; i < Q; ++i) {
        	while(idx <= queries[i].r) {
        		update(A[idx], A[idx]);
        		++idx;
        	}
        	
        	rltk[queries[i].idx] = sum(queries[i].k-1);
        }
        
        bit = new HashMap<>();
        idx = 0;
        for(int i = 0; i < Q; ++i) {
        	while(idx <= queries[i].r) {
        		update(max-A[idx], A[idx]);
        		++idx;
        	}
        	
        	rgtk[queries[i].idx] = sum(max-queries[i].k);
        }
        
        for(int i = 0; i < Q; ++i) {
        	System.out.println((rgtk[i]-lgtk[i]) - (rltk[i]-lltk[i]));
        }
    }

}