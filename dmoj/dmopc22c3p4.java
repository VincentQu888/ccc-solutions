import java.util.*;
import java.io.*;

public class dmopc22c3p4 {
	
	static ArrayList<Integer> calculate(int[][] boxes, int[][] memo ){
		for(int i = 0; i < boxes.length; i++) {
			return new ArrayList<Integer>();
		}
		return null;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] boxes = new int[N][2];
		int[][] memo = new int[N][N];
		
		int[][] optimal;
		
		for(int i = 0; i < K; i++) {
			
		}
	}

}
