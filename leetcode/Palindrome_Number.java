package Solved;

class Palindrome_Numbers {
	public boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        int counter = 0;
        if(x < 0){
            return false;
        }
        if(number.length() == 1){
            return true;
        }
        for(int i = 0; i < number.length()/2; i++) {
        	if(Integer.parseInt(String.valueOf(number.charAt(i))) == Integer.parseInt(String.valueOf(number.charAt(number.length()-1-i)))) {
        		counter++;
            }
        }
		if(counter == number.length()/2){
            return true;
        }else{
            return false; 
        }
    }
}
