import java.util.*;
import java.io.*;

public class ccc21s3 {
	
	static friend[] friends;
	
	public static class friend{
		int position;
		int speed;
		int hearing;
		
		public friend(int position, int speed, int hearing) {
			this.position = position;
			this.speed = speed;
			this.hearing = hearing;
		}
	}
	
	
	public static long dist(int position) {
		long sum = 0;
		
		for(friend f : friends) {
			long distance = Math.abs(position-f.position)-f.hearing;
			if(distance > 0) {
				sum += distance*f.speed;
			}
		}
		
		return sum;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		int high = 0;
		int low = Integer.MAX_VALUE;
		friends = new friend[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()),
			W = Integer.parseInt(st.nextToken()),
			D = Integer.parseInt(st.nextToken());
		
			friends[i] = new friend(P, W, D);
			if(P > high) high = P;
			if(P < low) low = P;
		}
		
		
		int mid = (high+low)/2;
		
		while(low <= high) {
			long cur = dist(mid);
			long curleft = dist(mid-1);
			long curright = dist(mid+1);
			
			if(curleft >= cur && curright >= cur) {
				out.println(cur);
				break;
			}
			else if(curleft <= cur) {
				high = mid;
				mid = (high+low)/2;
			}else {
				low = mid;
				mid = (high+low)/2;
			}
		}
		out.flush();
	}

}
