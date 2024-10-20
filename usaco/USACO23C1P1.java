import java.util.*;
import java.io.*;

public class USACO23C1P1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        String field = br.readLine();
        int[] range = new int[N];
        char leftmost;
        int idx = 0;
        int ans = 1;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) range[i] = Integer.parseInt(st.nextToken())-1;
        
    	if(field.charAt(0) == 'G') leftmost = 'G';
    	else leftmost = 'H';
    	
        for(int i = 0; i < N; i++) {
        	if(field.charAt(i) != leftmost) {
        		idx = i;
        		break;
        	}
        }
        
        
        for(int i = range[0]+1; i < N; i++) {
        	if(field.charAt(i) == field.charAt(0)) {
        		ans--;
        		break;
        	}
        }
        if(ans == 0) if(range[0] >= idx) ans++;
        for(int i = 1; i < idx; i++) if(range[i] >= idx) ans++;
       
        
        out.println(ans);
        out.flush();
    }

}