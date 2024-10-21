import java.util.*;
import java.io.*;

public class sac22cc5jp2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int M = Integer.parseInt(st.nextToken());
        	int O = Integer.parseInt(st.nextToken());
        	
        	if(M > O) ans++;
        }
        
        
        out.println(ans);
        out.flush();
        
	}

}
