import java.util.*;

public class ccc12j1 {
	
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int a = sc.nextInt();
	  int b = sc.nextInt();
      if(b <= a){
    	  System.out.println("Congratulations, you are within the speed limit!");
      }else if(b - a < 21){
    	  System.out.println("You are speeding and your fine is $100.");
      }else if(b - a < 31){
    	  System.out.println("You are speeding and your fine is $270.");
      }else{
    	  System.out.println("You are speeding and your fine is $500.");
      	}

   	}
  
}