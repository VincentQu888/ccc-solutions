import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class sac22cc5jp1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out = new PrintWriter(System.out);
	        
	        int X = Integer.parseInt(br.readLine());
	        int T = Integer.parseInt(br.readLine());
	        int W = Integer.parseInt(br.readLine());
	        
	        out.println(W-X);
	        
	        
	        out.flush();
	}

}
