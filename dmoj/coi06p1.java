import java.util.*;
import java.io.*;

public class coi06p1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N], maxl = new int[N], maxr = new int[N], maxeql = new int[N], maxeqr = new int[N];
        Deque<Integer> maxs = new LinkedList<>();
        Deque<Integer> maxeqs = new LinkedList<>();
        
        
        for(int i = 0; i < N; ++i) {
        	sequence[i] = Integer.parseInt(br.readLine());
        	

			while(!maxs.isEmpty() && sequence[i] > sequence[maxs.peekLast()]) {
    			maxr[maxs.pollLast()] = i;
    		}
    		
			if(!maxs.isEmpty()) maxl[i] = maxs.peekLast();
    		maxs.add(i);
    		
    		
    		while(!maxeqs.isEmpty() && sequence[i] >= sequence[maxeqs.peekLast()]) {
    			maxeqr[maxeqs.pollLast()] = i;
    		}
    		
			if(!maxeqs.isEmpty()) maxeql[i] = maxeqs.peekLast();
    		maxeqs.add(i);
    	}
        
        for(int i = 0; i < N; ++i) {
        	if(sequence[maxr[i]] < sequence[i] || maxr[i] <= i) maxr[i] = N;
        	if(sequence[maxl[i]] < sequence[i] || maxl[i] >= i) maxl[i] = -1;
        	if(sequence[maxeqr[i]] < sequence[i] || maxeqr[i] <= i) maxeqr[i] = N;
        	if(sequence[maxeql[i]] < sequence[i] || maxeql[i] >= i) maxeql[i] = -1;
        }
        

        int ans = 0;
        for(int i = 0; i < N; ++i) {
        	ans += maxr[i]-maxl[i]-1;

        	int idx = maxr[i] < N ? maxeqr[maxr[i]] : N;
        	while(idx < N && sequence[idx] != -1) {
        		--ans;
        		idx = maxeqr[idx];
        	}
        	
        	idx = maxl[i] >= 0 ? maxeql[maxl[i]] : 0;
        	while(idx >= 0 && sequence[idx] != -1) {
        		--ans;
        		idx = maxeql[idx];
        	}
        }
        
        System.out.println(ans);
    }

}