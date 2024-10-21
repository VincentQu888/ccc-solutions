import java.util.*;
import java.io.*;

public class bittest {
	
	static long[] bit;
	static long[] bitMin = new long[100005+1];
	static int[] freq = new int[100005];
	
	static void update(int pos, long val) {
		for(int i = pos+1; i < bit.length; i += i & -i) bit[i] += val;
	}
	
	static long query(int pos) {
		long ans = 0;
		for(int i = pos+1; i > 0; i -= i & -i) ans += bit[i];
	  
		return ans;
	}
	
	static void updateMin(int pos, long val) {
		for(int i = pos+1; i < bitMin.length; i += i & -i) bitMin[i] += val;
	}
	
	static long queryMin(int pos) {
		long ans = 0;
		for(int i = pos+1; i > 0; i -= i & -i) ans += bitMin[i];
	  
		return ans;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        bit = new long[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
        	int next = Integer.parseInt(st.nextToken());
        	update(i, next);
        	++freq[next];
        }
        for(int i = 0; i < freq.length; ++i) {
        	updateMin(i, freq[i]);
        }
        
        
        for(int i = 0; i < M; ++i) {
        	st = new StringTokenizer(br.readLine());
        	char cmd = st.nextToken().charAt(0);
        	
        	if(cmd == 'C') {
        		
        		int x = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		
        		int old = (int)(query(x-1)-query(x-2));
        		updateMin(old, -1);
        		updateMin(v, 1);
        		update(x-1, v-old);
        	}else if(cmd == 'S') {
        		System.out.println(-query(Integer.parseInt(st.nextToken())-2) + query(Integer.parseInt(st.nextToken())-1));
        	}else {
        		System.out.println(queryMin(Integer.parseInt(st.nextToken())));
        	}
        }
    }

}