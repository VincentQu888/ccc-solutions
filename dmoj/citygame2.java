import java.util.*;
import java.io.*;

public class citygame2 {
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[][] city = new int[H][W];
        int[][][] max = new int[H][W][W];
        
        for(int i = 0; i < H; ++i) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < W; ++i) {
        		city[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i = 0; i < H; ++i) {
            Deque<Integer> deque = new LinkedList<>();
            
        	for(int j = 0; j < N; ++j) {
        		while(!deque.isEmpty() && city[i][j] > city[i][deque.poll()]) {
        			deque.removeLast();    
        		}
        		deque.addLast(j);
        	}

    		max[i][0][N-1] = city[i][deque.peekFirst()];
        	for(int l = 1, r = N; r < W; ++l, ++r) {
        		while(!deque.isEmpty() && city[i][r] > city[i][deque.poll()]) {
        			deque.removeLast();    
        		}
        		deque.addLast(r);
        		
        		while(deque.pollLast()-deque.pollFirst() >= N) deque.removeFirst();
        		max[i][l][r] = city[i][deque.peekFirst()];
        	}
        }
        
        
        for(int x1 = 0, x2 = N; x2 < H; ++x1, ++x2) {
        	for(int y1 = 0, y2 = N; y2 < W; ++y1, ++y2) {
        		
        	}
        }
    }

}