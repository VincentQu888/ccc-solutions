import java.io.*;
import java.util.*;

public class ccc15s3 {
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] airport = new int[G];
        int ans = 0;
        
        for(int i = 0; i < P; i++) {
            int number = Integer.parseInt(br.readLine())-1;
            
            while(number >= 0 && airport[number] != 0) {
                int temp = airport[number];
                airport[number]++;
                number = number-temp;
            }
            if(number < 0) {
                break;
            }else{
                airport[number] = 1;
                ans++;
            }
        }
        out.println(ans);
        out.flush();
    }

}