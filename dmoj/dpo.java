import java.util.*;
import java.io.*;

public class dpo {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] compatibility = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		compatibility[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i = N-1; i >= 0; i--) {
        	for(int j = N-1; j >= 0; j--) {
        		for(int k = N-1; k >= 0; k--) {
        			
        		}
        	}
        }
    }

}