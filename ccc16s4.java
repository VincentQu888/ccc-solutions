import java.util.*;
import java.io.*;

public class ccc16s4 {
	
	static int[][] memo = new int[401][401];
	static int[] psa = new int[401];
	static int max = Integer.MIN_VALUE;
	
	
	public static boolean combinable(int l, int r) {
		if(memo[l][r] == -1) return false;
		if(memo[l][r] == 1) return true;
		if(l == r) return true;
		
		
		for(int i = l; i < r; ++i) {
			if(combinable(l, i) && combinable(i+1, r) && psa[i+1]-psa[l] == psa[r+1] - psa[i+1]) {
				max = Math.max(psa[r+1]-psa[l], max);
				memo[l][r] = 1;
						
				return true;
			}
		}
		
		int a = l; //left pointer
		int b = r; //right pointer
		while(a < b) {
			if(psa[a+1]-psa[l] == psa[r+1]-psa[b] && combinable(l, a) && combinable(a+1, b-1) && combinable(b, r)) {
				max = Math.max(psa[r+1]-psa[l], max);
				memo[l][r] = 1;
				
				return true;
			}
			
			if(psa[a+1]-psa[l] > psa[r+1]-psa[b]) b--;
			else a++;
		}
				
	
		memo[l][r] = -1;
		return false;
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] riceballs = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			riceballs[i] = Integer.parseInt(st.nextToken());
			psa[i+1] = riceballs[i] + psa[i];
			
			max = Math.max(riceballs[i], max);
		}
		
		
		combinable(0, N-1);
		System.out.println(max);
	}

}