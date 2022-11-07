import java.util.*;

public class ccc22j3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		    String instructions = sc.next();
		    char plus = '+';
		    char minus = '-';
		    int counter = 0;
		    boolean loop = false;
		    for(int i = 0; i < instructions.length(); i++){
		      if(instructions.charAt(i) == plus){
		        System.out.print(" tighten ");
		      }else if(instructions.charAt(i) == minus){
		        System.out.print(" loosen ");
		      }else if(Character.isDigit(instructions.charAt(i)))        {
		        if(counter+1 > instructions.length()){
		          System.out.print(instructions.charAt(i));
		          System.out.println();
		        }else{
		while(Character.isDigit(instructions.charAt(i+counter)) || loop == false)        {
		          System.out.print(instructions.charAt(i));
		          if(counter+1 > instructions.length()){
		            System.out.print(instructions.charAt(i));
		            System.out.println();
		            loop = true;
		        }else{
		            counter++;
		        }
		        }
		        counter = 0;
		        System.out.println(); 
		        }
		      }else{
		        System.out.print(instructions.charAt(i));
		      }
		    }
	}

}
