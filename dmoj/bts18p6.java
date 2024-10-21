import java.util.*;
import java.io.*;

public class bts18p6 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        
        long[] quadratic = new long[T+2];
        long[] linear = new long[T+2];
        long[] constant = new long[T+2];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        	long a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        	
        	quadratic[l] += a;
        	quadratic[r+1] -= a;
        	
        	linear[l] += b-2*a*l;
        	linear[r+1] -= b-2*a*l;
        	
        	constant[l] += a*l*l - b*l + c;
        	constant[r+1] -= a*l*l - b*l + c;
        }

        for(int i = 1; i <= T; i++) {
        	quadratic[i] += quadratic[i-1];
        	linear[i] += linear[i-1];
        	constant[i] += constant[i-1];
        }
        
        for(int i = 1; i <= T; i++) {
        	out.print(quadratic[i]*i*i + linear[i]*i + constant[i] + " ");
        }
        out.flush();
    }

}