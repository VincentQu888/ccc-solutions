/* bro i wont even lie i dont even know how or why this works but i just experimented with random prime numbers and eventually it worked and i hate it and i hate hashing
 */

import java.util.*;
import java.io.*;

public class ccc20s3 {
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String needle = br.readLine();
		String haystack = br.readLine();
		long hash = 0, hash2 = 0;
		int mod = 12582917, mod2 = 12582893;
		int ans = 0;
		
		HashSet<Long> permutations = new HashSet<>();
		HashSet<Long> permutations2 = new HashSet<>();
		int[] base = new int[26]; //arrays to avoid hash collisions
		int[] window = new int[26];
		
		
		if(needle.length() > haystack.length()) {
			out.println(0);
			out.flush();
			System.exit(0);
		}
		
		for(int i = 0; i < needle.length(); i++) {
			window[haystack.charAt(i)-'a']++;
			base[needle.charAt(i)-'a']++;
			
			hash = (26 * hash + haystack.charAt(i)) % mod;
			hash2 = (26 * hash2 + haystack.charAt(i)) % mod2;
		}
		if(Arrays.equals(base, window)) {
			ans++;
			permutations.add(hash);
			permutations2.add(hash2);
		}
		out.println(hash + ", " + hash2);

		int h = 1;
		int h2 = 1;
		for (int i = 0; i < needle.length() - 1; i++) {
			h = (h * 26) % mod;
			h2 = (h2 * 26) % mod2;
		}
		
		for(int i = needle.length(); i < haystack.length(); i++){
			window[haystack.charAt(i-needle.length())-'a']--;
			window[haystack.charAt(i)-'a']++;
			
			hash = (26 * (hash - haystack.charAt(i-needle.length()) * h) + haystack.charAt(i)) %mod;
			if (hash < 0) hash += mod;
			
			hash2 = (26 * (hash2 - haystack.charAt(i-needle.length()) * h2) + haystack.charAt(i)) %mod2;
			if (hash2 < 0) hash2 += mod2;
			
			if(Arrays.equals(base, window)) {
				if(!permutations.contains(hash) || !permutations2.contains(hash2)) {
					ans++;
					permutations.add(hash);
					permutations2.add(hash2);
				}
			}
			out.println(hash + ", " + hash2);
		}
		
		out.println(ans);
		out.flush();
	}

}