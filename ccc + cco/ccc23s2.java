import java.util.*;
import java.io.*;

public class ccc23s2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] mountains = new int[N];
        int[] min = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
        	mountains[i] = Integer.parseInt(st.nextToken());
        	min[i] = Integer.MAX_VALUE;
        }
        
        
        for(int i = 0; i < N; ++i) {
        	int crop = 0;
        	
        	for(int j = 0; j+i < N && i-j >= 0; ++j) {
        		crop += Math.abs(mountains[i+j] - mountains[i-j]);
        		min[j*2] = Math.min(crop, min[j*2]);
        	}
        }
        
        for(int i = 0; i < N-1; ++i) {
			int crop = 0;
        	
        	for(int j = 0; j+i+1 < N && i-j >= 0; ++j) {
        		crop += Math.abs(mountains[i+j+1] - mountains[i-j]);
        		min[j*2+1] = Math.min(crop, min[j*2+1]);
        	}
        }
        
        
        for(int next : min) System.out.print(next + " ");
    }

}