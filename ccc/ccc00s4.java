import java.util.*;
import java.io.*;

public class ccc00s4 {
    
    static int bestSum(int[] clubs, int[] step, int target) {
        int ans = (int) 1e9; 
        if(step[target] != -1) return step[target];
        if(target == 0) return 0;
        
        for(int i = 0; i < clubs.length; i++) {
            if(target-clubs[i] >= 0) {
                ans = Math.min(bestSum(clubs, step, target-clubs[i])+1, ans);
            }
        }
        return step[target] = ans;
    }
    
    public static void main(String[] args)throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int distance = Integer.parseInt(br.readLine());
        int numClubs = Integer.parseInt(br.readLine());
        int[] clubs = new int[numClubs];
        int[] step = new int[distance+1];
        Arrays.fill(step, -1); 
        
        for(int i = 0; i < numClubs; i++) {
            clubs[i] = Integer.parseInt(br.readLine());
        }
        
        int ans = bestSum(clubs, step, distance);
        if(ans < (int) 1e9) {
            out.println("Roberta wins in " + ans + " strokes.");
        }else {
            out.println("Roberta acknowledges defeat.");
        }
        out.flush();
    }

}