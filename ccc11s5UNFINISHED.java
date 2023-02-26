import java.util.*;
import java.io.*;

public class ccc11s5UNFINISHED { //90/100 on testcases
	
	static int ans = 0;
	static int[] lights;
	
	public static boolean finished() {
		for(int light : lights) if(light == 1) return false;
		return true;
	}
	
	public static void flip() {
		int lstart = 0;
		int lend = 0;
		int rstart = 0;
		int rend = 0;
		int counter = 0;
		
		for(int i = 0; i < lights.length; i++) {
			if(lights[i] == 1) {
				lstart = i;
				for(int j = i; j < lights.length; j++) {
					if(lights[j] == 0) {
						lend = j-1;
						break;
					}else lend = j;
				}
				break;
			}
		}
		
		for(int i = lights.length-1; i >= 0; i--) {
			if(lights[i] == 1) {
				rend = i;
				for(int j = i; j >= 0; j--) {
					if(lights[j] == 0) {
						rstart= j+1;
						break;
					}else rstart = j;
				}
				break;
			}
		}
		
		if(Math.abs(lend-lstart) < Math.abs(rend-rstart)) {
			if(Math.abs(lights.length/2-(lend+1)) < Math.abs(lights.length/2-(lstart-1))) {
				lights[lend+1] = 1;
				for(int i = lstart; i < lights.length && lights[i] == 1; i++) counter++;
				
				if(counter >= 4) {
					for(int i = lstart; i < lights.length && lights[i] == 1; i++) lights[i] = 0;
				}
			}
			else {
				lights[lstart-1] = 1;
				for(int i = lend; i >= 0 && lights[i] == 1; i--) counter++;
				
				if(counter >= 4) {
					for(int i = lend; i >= 0 && lights[i] == 1; i--) lights[i] = 0;
				}
			}
		}else {
			if(Math.abs(lights.length/2-(rend+1)) < Math.abs(lights.length/2-(rstart-1))) {
				lights[rend+1] = 1;
				for(int i = rstart; i < lights.length && lights[i] == 1; i++) counter++;
				
				if(counter >= 4) {
					for(int i = rstart; i < lights.length && lights[i] == 1; i++) lights[i] = 0;
				}
			}
			else {
				lights[rstart-1] = 1;
				for(int i = rend; i >= 0 && lights[i] == 1; i--) counter++;
				
				if(counter >= 4) {
					for(int i = rend; i >= 0 && lights[i] == 1; i--) lights[i] = 0;
				}
			}
		}
		
		ans++;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int K = Integer.parseInt(br.readLine());
        lights = new int[K];
        
        for(int i = 0; i < K; i ++) lights[i] = Integer.parseInt(br.readLine());
        while(!finished()) flip();
  
        out.println(ans);
        out.flush();
    }

}