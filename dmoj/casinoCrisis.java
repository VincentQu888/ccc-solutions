import java.util.*;
import java.io.*;

public class casinoCrisis {
	
	static int[] arr;
	
	public static void operation(int l, int r) {
		while(l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			++l;
			--r;
		}
	}
	
	public static int find(int idx) {
		for(int i = 0; i < idx; ++i) {
			if(arr[i] > arr[idx]) return i;
		}
		
		return -1;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 1; i < N; ++i) {
        	if(arr[i] < arr[i-1]) {
        		int l = find(i);
        		operation(l, i-1);
        		operation(l, i);
        		
        		ans.add(new int[]{l, i-1});
        		ans.add(new int[]{l, i});
        	}
        }
        
        System.out.println(ans.size());
        for(int[] next : ans) System.out.println((next[0]+1) + " " + (next[1]+1));
    }

}