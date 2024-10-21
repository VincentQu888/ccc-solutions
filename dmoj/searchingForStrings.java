import java.util.*;

public class searchingForStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String needle = sc.nextLine();
		String haystack = sc.nextLine();
	      int count = (haystack.split(needle).length)-1;
	      int numberOfPermutations = needle.length();
	      int numberOfPermutationsHelp = numberOfPermutations-1;
	      while(numberOfPermutationsHelp < 0) {
	    	 numberOfPermutations = numberOfPermutations*numberOfPermutationsHelp;
	    	 numberOfPermutationsHelp--;
	      }
	      for(int i = 0; i < numberOfPermutations; i++) {
	    	  
	      }
	}
	      
	static void function(String str, String ans){
		boolean alpha[] = new boolean[26];

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			String ros = str.substring(0, i) + str.substring(i + 1);

			if (alpha[ch - 'a'] == false)
				function(ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
	}
}
