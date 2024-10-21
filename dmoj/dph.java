import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class dph {
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		BigInteger[][] lab = new BigInteger[R][C];
		
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '#') lab[i][j] = BigInteger.valueOf(-1);
				else lab[i][j] = BigInteger.valueOf(0);
			}
		}
		
		
		lab[0][0] = BigInteger.valueOf(1);
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(lab[i][j].compareTo(BigInteger.valueOf(-1)) != 0) {
					try {
						if(lab[i][j-1].compareTo(BigInteger.valueOf(-1)) != 0) {
							lab[i][j] = lab[i][j].add(lab[i][j-1]);
						}
					}catch(ArrayIndexOutOfBoundsException aioobe){}
					try {
						if(lab[i-1][j].compareTo(BigInteger.valueOf(-1)) != 0) {
							lab[i][j] = lab[i][j].add(lab[i-1][j]);
						}
					}catch(ArrayIndexOutOfBoundsException aioobe){}
				}
			}
		}
		
		out.println(lab[R-1][C-1].mod(BigInteger.valueOf((int)(1e9+7))));
		out.flush();
	}

}
