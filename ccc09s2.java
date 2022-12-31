//this question is really stupid unless im reading the problem statement wrong this calculation is straight up incorrect
//it calculates all of the unique rows starting from flipping from the very topmost button 
//rather than calculating all the different permutations of the bottom with any combination of light switches

import java.util.*;
import java.io.*;

public class ccc09s2 {
	
	static HashSet<String> permutations = new HashSet<>();
	
	public static void permutation(int[][] lights, int start) {
		if(start >= 0) {
			for(int i = 0; i < lights[start].length; i++) {
				if(lights[start][i] != lights[start+1][i]) {
					lights[start][i] = 1;
				}else {
					lights[start][i] = 0;
				}
			}
			permutations.add(Arrays.toString(lights[start]));
			permutation(lights, start-1);
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int R = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		int[][] lights = new int[R][L];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < L; j++) {
				lights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
	
		permutation(lights, R-2);
		permutations.add(Arrays.toString(lights[R-1]));
		
		out.println(permutations.size());
		out.flush();
	}

}


//this is what i feel like should be the solution
/*
import java.util.*;
import java.io.*;

public class ccc09s2UNFINISHED {
	
	public static String permutation(int[][] lights, int start) {
		int[][] arr = new int[lights.length][lights[0].length];
		for(int i = 0; i < lights.length; i++) {
			for(int j = 0; j < lights[0].length; j++) {
				arr[i][j] = lights[i][j];
			}
		}
		
		if(start >= 0) {
			for(int i = 0; i < arr[start].length; i++) {
				if(arr[start][i] != arr[start+1][i]) {
					arr[start][i] = 1;
				}else {
					arr[start][i] = 0;
				}
			}
			return permutation(arr, start-1);
		}
		return Arrays.toString(arr[0]);
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int R = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		int[][] lights = new int[R][L];
		HashSet<String> permutations = new HashSet<>();
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < L; j++) {
				lights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		permutations.add(Arrays.toString(lights[0]));
		for(int i = 0; i < R-1; i++) {
			permutations.add(permutation(lights, i));
		}
		
		out.println(permutations.size());
		out.flush();
	}

}
*/

//anyways maybe im just dumb lol
