import java.util.*;
import java.io.*;

public class coci09c6p2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int ans = S;
		
		int[] damaged = new int[S];
		HashSet<Integer> spares = new HashSet<>();
		HashSet<Integer> repaired = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < S; i++) {
			damaged[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			spares.add(Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i = 0; i < S; i++) {
			if(spares.contains(damaged[i])) {
				spares.remove(damaged[i]);
				repaired.add(damaged[i]);
				ans--;
			}
		}
		for(int i = 0; i < S; i++) {
			if(spares.contains(damaged[i]-1) && !repaired.contains(damaged[i])) {
				spares.remove(damaged[i]-1);
				ans--;
			}else if(spares.contains(damaged[i]+1) && !repaired.contains(damaged[i])) {
				spares.remove(damaged[i]+1);
				ans--;
			}
		}
		
		out.println(ans);
		out.flush();
	}

}
