import java.util.*;
import java.io.*;

public class dmopc21c6p1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int D = Integer.parseInt(br.readLine());
        int l = 0;
        int r = 0;
        
        String temp = br.readLine();
        for(int i = 0; i < D-1; i++) {
        	if(temp.charAt(i) < temp.charAt(i+1)) {
        		l = i;
        		r = i+1;
        		break;
        	}
        }
        
        if(r == 0) out.println(temp);
        else {
        	for(int i = 0; i < D; i++) {
        		if(i == l) {
        			out.print(temp.charAt(i+1));
        			out.print(temp.charAt(i));
        			i++;
        		}else out.print(temp.charAt(i));
        	}
        }
        
        out.flush();
    }

}