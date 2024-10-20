import java.util.*;
import java.io.*;

public class USACO23C1P3 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         PrintWriter out = new PrintWriter(System.out);
         
         int Q = Integer.parseInt(br.readLine());
         int ans;
         
         for(int i = 0; i < Q; i++) {
         	ans = 0;
         	String str = br.readLine();
         	
         	ans += str.length()-3;
         	
         	if(!str.contains("MOO")) {
             	if(str.contains("MOM")) ans++;
             	else if(str.contains("OOO")) ans++;
             	else if(str.contains("OOM")) ans+=2;
             	else ans = -1;
         	}
         	
         	System.out.println(ans);
         }
    }

}