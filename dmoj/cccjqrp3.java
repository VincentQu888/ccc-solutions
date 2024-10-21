import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class cccjqrp3 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken()), b = new BigInteger(st.nextToken()), c = new BigInteger(st.nextToken());
        
        out.println(a.add(b).add(c));
        out.flush();
    }

}