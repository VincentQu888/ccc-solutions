import java.util.*;
import java.io.*;

public class coci15c2p4 {
    
    static ArrayList<Long>[] hash;
    static long[] pow;
    static String[] str;
    static int base = 139;
    static int mod = (int) 1e9+7;
    
    public static boolean possible(int i, int j) {
        if(str[i].length() > str[j].length()) return false;
        
        if((long)hash[j].get(str[i].length()) == (long)hash[i].get(str[i].length()) && (hash[j].get(str[j].length()) - hash[j].get(str[j].length()-str[i].length())*pow[str[i].length()] % mod + mod) % mod == hash[i].get(str[i].length())) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        str = new String[N];
        hash = new ArrayList[N];
        pow = new long[N+1];
        int[] dp = new int[N];
        pow[0] = 1;
        
        for(int i = 0; i < N; ++i) {
            hash[i] = new ArrayList<>();
            str[i] = br.readLine();
        }
        
        for(int i = 0; i < N; ++i) {
            hash[i].add((long) 0);
            for(int j = 1; j <= str[i].length(); ++j) {
                hash[i].add(hash[i].get(j-1)*base + str[i].charAt(j-1) % mod);
            }
        }
        for(int i = 1; i <= N; ++i) pow[i] = pow[i-1]*base % mod;
        
        
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < i; ++j) {
                if(possible(j, i)) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(ans, dp[i]);
        }
        
        System.out.println(ans);
    }

}