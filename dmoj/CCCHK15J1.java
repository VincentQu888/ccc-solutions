import java.util.*;
import java.io.*;

public class CCCHK15J1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        String[] alice = new String[N];
        String[] bob = new String[N];
        int ascore = 0;
        int bscore = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) alice[i] = st.nextToken();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) bob[i] = st.nextToken();
        
        
        for(int i = 0; i < N; i++) {
        	String a = alice[i];
        	String b = bob[i];
        	
        	if(a.equals("rock") && b.equals("paper")) bscore++;
        	if(a.equals("rock") && b.equals("scissors")) ascore++;
        	if(a.equals("scissors") && b.equals("paper")) ascore++;
        	if(a.equals("scissors") && b.equals("rock")) bscore++;
        	if(a.equals("paper") && b.equals("rock")) ascore++;
        	if(a.equals("paper") && b.equals("scissors")) bscore++;
        }
        
        out.println(ascore + " " + bscore);
        out.flush();
    }

}