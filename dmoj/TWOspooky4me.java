import java.util.*;
import java.io.*;

public class TWOspooky4me {
	
	public static int index(int coord, ArrayList<Integer> coords) {
		for(int i = 0; i < coords.size(); ++i) {
			if(coords.get(i) == coord) return i;
		}
		
		return -1;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        
        HashSet<Integer> temp = new HashSet<>();
        int[][] updates = new int[N][3];
        for(int i = 0; i < N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        	temp.add(a);
        	temp.add(b);
        	
        	updates[i] = new int[]{a, b, s};
        }
        
        ArrayList<Integer> coords = new ArrayList<>();
        for(int next : temp) {
        	coords.add(next);
        }
        Collections.sort(coords);
        
        coords.add(0, 1);
        coords.add(L);
        int[] diff = new int[coords.size()*2+1];
        
        
        for(int i = 0; i < N; ++i) {
        	int a = updates[i][0];
        	int b = updates[i][1];
        	int s = updates[i][2];
        	
        	diff[index(a, coords)*2] += s;
        	diff[index(b, coords)*2+1] -= s;
        }
        
        int[] psa = new int[diff.length];
        for(int i = 1; i < diff.length; ++i) {
        	psa[i] = psa[i-1] + diff[i-1];
        }
        
        int ans = 0;
        for(int i = 1; i < diff.length-1; ++i) {
        	if(psa[i] < S) {
        		if(i%2 == 0) ans += coords.get(i/2)-coords.get(i/2-1)-1;
        		else ++ans;
        	}
        }
        
        System.out.println(ans);
    }

}