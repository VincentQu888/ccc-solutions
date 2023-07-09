import java.util.*;
import java.io.*;

public class ccc23s3 {
	
	public static boolean palindrome(char[] arr) {
		for(int i = 0; i < arr.length/2; ++i) {
			if(arr[i] != arr[arr.length-1-i]) return false;
		}
		
		return true;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        char[][] poster = new char[N][M];
        int rows = 0;
        int columns = 0;
        int big = 0;
        
        
        for(int i = 0; i < R; ++i) {
        	for(int j = 0; j < M; ++j) {
        		poster[i][j] = 'a';
        	}
        }
        
        for(int i = 0; i < C; ++i) {
        	for(int j = 0; j < N; ++j) {
        		poster[j][i] = 'a';
        	}
        }
        
        for(int i = 0; i < N; ++i) {
        	int counter = big;
        	for(int j = 0; j < M; ++j) {
        		if(poster[i][j] != 'a') {
        			poster[i][j] = (char)(counter + 'b');
        			counter = counter >= 21 ? 0 : counter+1; //21 is arbitrary number less than 26
        		}
        	}
        	big = big >= 21 ? 0 : big+1;
        }
        
        
        
        if(R == N) {
        	int goal = M-C;
        	
        	if(M%2 == 0) {
        		if(goal%2 == 0) {
        			for(int i = 0; goal > 0; ++i) {
        				poster[0][i] = 'z';
        				poster[0][M-1-i] = 'z';
        				goal -= 2;
        			}
        		}else {
        			
        		}
        	}else {
        		if(goal%2 == 0) {
        			for(int i = 0; goal > 0; ++i) {
        				poster[0][i] = 'z';
        				poster[0][M-1-i] = 'z';
        				goal -= 2;
        			}
        		}else {
        			poster[0][M/2] = 'z';
        			goal--;
        			for(int i = 0; goal > 0; ++i) {
        				poster[0][i] = 'z';
        				poster[0][M-1-i] = 'z';
        				goal -= 2;
        			}
        		}
        	}
        }
        if(C == M) {
        	int goal = N-R;
        	
        	if(N%2 == 0) {
        		if(goal%2 == 0) {
        			for(int i = 0; goal > 0; ++i) {
        				poster[i][0] = 'z';
        				poster[N-1-i][0] = 'z';
        				goal -= 2;
        			}
        		}else {
        			
        		}
        	}else {
        		if(goal%2 == 0) {
        			for(int i = 0; goal > 0; ++i) {
        				poster[i][0] = 'z';
        				poster[N-1-i][0] = 'z';
        				goal -= 2;
        			}
        		}else {
        			poster[N/2][0] = 'z';
        			goal--;
        			for(int i = 0; goal > 0; ++i) {
        				poster[i][0] = 'z';
        				poster[N-1-i][0] = 'z';
        				goal -= 2;
        			}
        		}
        	}
        }
        
        
        
        for(int i = 0; i < N; ++i) {
        	if(palindrome(poster[i])) rows++;
        }
        
        for(int i = 0; i < M; ++i) {
        	char[] temp = new char[N];
        	for(int j = 0; j < N; ++j) {
        		temp[j] = poster[j][i];
        	}
        	
        	if(palindrome(temp)) columns++;
        }
        
        
        if(R == rows && C == columns) {
        	for(int i = 0; i < N; ++i) {
        		for(int j = 0; j < M; ++j) {
        			System.out.print(poster[i][j]);
        		}
        		System.out.println();
        	}
        }else {
        	System.out.println("IMPOSSIBLE");
        }
    }

}