import java.util.*;
import java.io.*;

public class dmpg16s5 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        long[] pizza = new long[N+K];
        
    	st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
        	pizza[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; ++i) {
        	pizza[N+i] = pizza[i];
        }
        
        
        long ans = pizza[0];
        long max = 0;
        long size = 0;
        for(int i = 0; i < N+K; ++i) {
        	max += pizza[i];
        	++size;
        	ans = Math.max(ans, max);
       
        	if(size >= K) {
        		max -= pizza[i-K+1];
        		--size;
        	}
        	if(max < 0) {
        		max = 0;
        		size = 0;
        	}
        }
        
        System.out.println(ans);
    }

}