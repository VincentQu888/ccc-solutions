import java.util.*;
import java.io.*;

public class USACO22C3P2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String field = br.readLine();
			int[] ans = new int[N];
			boolean[] used = new boolean[N];
			int counter = 0;
			boolean loop = true;
			
			
			while(loop) {
				int numH = 0;
				int numG = 0;
				int finalNumG = 0;
				int finalNumH = 0;
				int gPosition = 0;
				int hPosition = 0;
				int finalPosition;
				
				for(int j = 0; j < N; j++) {
					for(int k = j-K; k < j+K; k++) {
						try {
							if(field.charAt(k) == 'G' && !used[k]) {
								numG++;
							}else if(!used[k]){
								numH++;
							}
						}catch(StringIndexOutOfBoundsException sioobe) {}
					}
					
					if(numG > finalNumG) {
						finalNumG = numG;
						gPosition = j;
					}
					if(numH < finalNumH) {
						finalNumH = numH;
						hPosition = j;
					}
				}
				
				if(finalNumH < finalNumG) {
					finalPosition = gPosition;
					ans[finalPosition] = 1;
					
					for(int j = finalPosition-K; j < finalPosition+K; j++) {
						try {
							try {
								if(field.charAt(j) == 'G') {
									used[j] = true;
								}
							}catch(ArrayIndexOutOfBoundsException aioobe) {}
						}catch(StringIndexOutOfBoundsException sioobe) {}
					}
				}else {
					finalPosition = hPosition;
					ans[finalPosition] = 2;
					
					for(int j = finalPosition-K; j < finalPosition+K; j++) {
						try {
							try {
								if(field.charAt(j) == 'H') {
									used[j] = true;
								}
							}catch(ArrayIndexOutOfBoundsException aioobe) {}
						}catch(StringIndexOutOfBoundsException sioobe) {}
					}
				}
				counter++;
				
				
				for(int j = 0; j < used.length; j++) {
					if(!used[j]) {
						loop = false;
						break;
					}
				}
				
				if(loop = false) {
					loop = true;
				}else {
					loop = false;
				}
			}
			
			out.println(counter);
			for(int j = 0; j < N; j++) {
				if(ans[j] == 1) {
					out.print("G");
				}else if(ans[j] == 2) {
					out.print("H");
				}else {
					out.print(".");
				}
			}
			out.println();
		}

		out.flush();
	}

}
