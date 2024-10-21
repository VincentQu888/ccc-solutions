import java.util.*;
import java.io.*;

public class bobstringsearch {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine(), t = br.readLine();
        
        long[] hash = new long[s.length()+1];
        long[] pow = new long[s.length()+1];
        int base = 139;
        int mod = (int) 1e9+7;
        long ht = 0;
        
        pow[0] = 1;
        for(int i = 1; i <= s.length(); ++i) {
        	hash[i] = (hash[i-1]*base + s.charAt(i-1)) % mod;
        	pow[i] = pow[i-1]*base % mod;
        }
        for(int i = 1; i <= t.length(); ++i) ht = (ht*base + t.charAt(i-1)) % mod;
        
        int ans = 0;
        for(int l = 1, r = t.length(); r <= s.length(); ++l, ++r) {
        	if(((hash[r] - hash[l-1]*pow[r-l+1] % mod + mod) % mod) == ht) ++ans;
        }
        System.out.println(ans);
    }

}