import java.util.*;
import java.io.*;

public class dmopc22c4p5 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        
        int ans = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	ans += Math.log(temp)/Math.log(2)-1;
        }
       
        if(ans%2 == 0) out.println("BOB");
        else out.println("ALICE");
        out.flush();
    }

}