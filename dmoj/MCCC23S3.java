import java.util.*;
import java.io.*;

public class MCCC23S3 {

    public static int toAmerica(boolean[] graph, int start, int K, int[] memo) {
    	if(memo[start] > 0) {
    		return memo[start];
    	}
        if(start == graph.length-1) {
        	int[] temp = new int[graph.length];
        	return toCanada(graph, graph.length-1, K, temp);
        }

        
        int ans = 0;
        for(int i = start+1; i < graph.length; i++) {
            if(start-i <= K) {
                graph[i] = false;
                memo[i] = toAmerica(graph, i, K, memo);
                graph[i] = true;
                ans += memo[i];
            }
        }
        return ans;
    }
    
    public static int toCanada(boolean[] graph, int start, int K, int[] memo) {
    	if(memo[start] > 0) return memo[start];
        if(start == 1) return 1;
        
        int ans = 0;
        for(int i = start-1; i > 0; i--) {
            if(start-i <= K && graph[i]) {
                memo[i] = toCanada(graph, i, K, memo);
                ans = memo[i];
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args)throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] graph = new boolean[N+1];
        int[] memo = new int[N+1];
        Arrays.fill(graph, true);
        
        out.println(toAmerica(graph, 1, K, memo)%998244353);
        out.flush();
    }

}