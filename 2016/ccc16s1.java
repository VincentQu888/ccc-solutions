import java.util.*;
import java.io.*;

public class ccc16s1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> comparisonMap = new HashMap<>();
		boolean anagram = true;
		ArrayList<Character> charsUsed = new ArrayList<>();
		
		String str = br.readLine();
		String comparedStr = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
				charsUsed.add(str.charAt(i));
				comparisonMap.put(str.charAt(i), 0);
			}else {
				int temp = map.get(str.charAt(i));
				map.put(str.charAt(i), temp+1);
			}
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(!comparisonMap.containsKey(comparedStr.charAt(i))) {
				comparisonMap.put(comparedStr.charAt(i), 1);
				map.put(comparedStr.charAt(i), 0);
				if(!charsUsed.contains(comparedStr.charAt(i)) && comparedStr.charAt(i) != '*') {
					charsUsed.add(comparedStr.charAt(i));
				}
			}else if(comparedStr.charAt(i) != '*'){
				int temp = comparisonMap.get(comparedStr.charAt(i));
				comparisonMap.put(comparedStr.charAt(i), temp+1);
			}
		}
		
		
		for(int i = 0; i < charsUsed.size(); i++) {
			if(comparisonMap.get(charsUsed.get(i)) > map.get(charsUsed.get(i))) {
				anagram = false;
				break;
			}
		}
		
		
		if(anagram) {
			out.println("A");
		}else {
			out.println("N");
		}
		out.println(map);
		out.println(comparisonMap);
		out.flush();
	}

}
