import java.util.*;
import java.io.*;

public class dpj {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sushi = new int[3];
        double[][][] dp = new double[301][301][301];
        double[][][] dp2 = new double[301][301][301];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	sushi[Integer.parseInt(st.nextToken())-1]++; 
        }

        
        dp[sushi[0]][sushi[1]][sushi[2]] = 1;
        for(int k = N; k >= 0; k--) {
        	for(int j = N; j >= 0; j--) {
        		for(int i = N; i >= 0; i--) {
        			 if(i == 0 && j == 0 && k == 0) {
                         continue;
                     }
                     if(i + j + k > N) {
                         continue;
                     }
                     
        			double pextra = (N - (i+j+k))/(double)N;
        			double eextra = (pextra/(1-pextra)) + 1;
        			
        			dp2[i][j][k] += eextra * dp[i][j][k];
        			
        			if(i > 0) {
        				dp[i-1][j][k] += dp[i][j][k] * (double)i/(i+j+k); 
        				dp2[i-1][j][k] += dp2[i][j][k] * (double)i/(i+j+k);
        			}
        			if(j > 0) {
        				dp[i+1][j-1][k] += dp[i][j][k] * (double)j/(i+j+k);
        				dp2[i+1][j-1][k] += dp2[i][j][k] * (double)j/(i+j+k);
        			}
        			if(k > 0) {
        				dp[i][j+1][k-1] += dp[i][j][k] * (double)k/(i+j+k);
        				dp2[i][j+1][k-1] += dp2[i][j][k] * (double)k/(i+j+k);
        			}
        		}
        	}
        }
        System.out.println(dp2[0][0][0]);
    }

}