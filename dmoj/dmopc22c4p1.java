import java.util.*;
import java.io.*;

public class dmopc22c4p1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] times = new int[N+3];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) times[i] = Integer.parseInt(st.nextToken());
        times[N+1] = M+1;
        times[N+2] = M+1;
        
        
        Arrays.sort(times);
        int gap = times[1]-1;
        for(int i = 1; i <= N; i++) {
        	gap = Math.max(gap, times[i+1]-times[i]-1);
        }
        gap = Math.max(gap, M-times[N]);
       
    	
    	
        int temp = times[0+1];
    	times[0+1] = times[0+1]+K <= M ? times[0+1]+K : M+1;
    	
    	gap = Math.max(gap, Math.min(times[0+1]-times[0]-1, times[0+2]-times[0]-1));
    	times[0+1] = temp;
    	
        
        for(int i = 1; i <= N; i++) {
        	int prev = times[i];
        	
        	times[i] = times[i]-K > 0 ? times[i]-K : 0;
        	gap = Math.max(gap, Math.min(times[i+1]-times[i]-1, times[i+1]-times[i-1]-1));
        	times[i] = prev;
        	
        	prev = times[i+1];
        	times[i+1] = times[i+1]+K <= M ? times[i+1]+K : M+1;
        	gap = Math.max(gap, Math.min(times[i+1]-times[i]-1, times[i+2]-times[i]-1));
        	times[i+1] = prev;
        }
        
        
        out.println(gap);
        out.flush();
    }

}