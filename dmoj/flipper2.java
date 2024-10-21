import java.util.*;

public class flipper2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 	String input = sc.nextLine();
	        int nH = 0;
	        int nV = 0;
	        char flips[] = input.toCharArray();
	        for(int i = 0; i < flips.length; i++) {
	            if(flips[i] == 'H') {
	                nH++;        
	            }
	            else{
	                nV++;
	            }
	        }
	        if(nH%2 == 1) {
	            if(nV%2 == 1) {
	                System.out.println("4 3");
	                System.out.println("2 1");
	            }
	            else{
	                System.out.println("3 4");
	                System.out.println("1 2");
	        }
	        }
	        else{
	            if(nV%2 == 1) {
	                System.out.println("2 1");
	                System.out.println("4 3");
	            }
	            else
	                System.out.println("1 2");
	                System.out.println("3 4");
	    }
	}

}
