import java.util.*;
import java.io.*;

public class lexicographicallyLeastSubstring {
	
    static long[] hash;
    static long[] pow;
    static int base = 139;
    static int mod = (int) 1e9+7;
    static String str;
    
    public static boolean compare(int l1, int r1, int l2, int r2) {
    	++l1;
    	++l2;
    	++r1;
    	++r2;
    	
    	int p1 = (l1+r1)/2;
    	int p2 = (l2+r2)/2;
    	
    	while(l1 < r1) {
    		if((hash[p1] - hash[l1-1]*pow[p1-l1+1] % mod + mod) % mod  == (hash[p2] - hash[l2-1]*pow[p2-l2+1] % mod + mod) % mod) {
    			l1 = p1+1;
    			l2 = p2+1;
    		}else {
    			r1 = p1-1;
    			r2 = p2-1;
    		}
    		
			p1 = (l1+r1)/2;
			p2 = (l2+r2)/2;
    	}

    	--l1;
    	--l2;
    	if(l1+1 < str.length() && l2+1 < str.length() && str.charAt(l1) == str.charAt(l2)) {
    		++l1;
    		++l2;
    	}
    	return str.charAt(l1) < str.charAt(l2);
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str = br.readLine();
        int K = Integer.parseInt(br.readLine());
        if(K < 1 || K > str.length()) {
        	System.out.println();
        	System.exit(0);
        }
        
        hash = new long[str.length()+1];
        pow = new long[str.length()+1];
        pow[0] = 1;
        
        for(int i = 1; i <= str.length(); ++i) {
        	hash[i] = (hash[i-1]*base + str.charAt(i-1)) % mod;
        	pow[i] = pow[i-1]*base % mod;
        }
        
        
        int minl = 0;
        int minr = K-1;
        for(int l = 1, r = K; r < str.length(); ++l, ++r) {
        	if(compare(l, r, minl, minr)) {
        		minl = l;
        		minr = r;
        	}
        }
        
        for(int i = minl; i <= minr; ++i) System.out.print(str.charAt(i));
    }

}