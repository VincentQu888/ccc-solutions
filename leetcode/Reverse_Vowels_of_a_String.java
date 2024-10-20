package Solved;

import java.util.ArrayList;

class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        
        char string[] = s.toCharArray();
        ArrayList<Integer>vowelPositions = new ArrayList<>();
        
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e'|| s.charAt(i) == 'i'|| s.charAt(i) == 'o'|| s.charAt(i) == 'u'|| s.charAt(i) == 'A'|| s.charAt(i) == 'E'|| s.charAt(i) == 'I'|| s.charAt(i) == 'O' || s.charAt(i) == 'U'){
                vowelPositions.add(i);
            }   
        }
        
        
        while(vowelPositions.size() > 1){
            char temp = string[vowelPositions.get(0)];
            string[vowelPositions.get(0)] = string[vowelPositions.get(vowelPositions.size()-1)];
            string[vowelPositions.get(vowelPositions.size()-1)] = temp;
            vowelPositions.remove(0);
            vowelPositions.remove(vowelPositions.size()-1);
            }
    
        return new String(string);
    }
}