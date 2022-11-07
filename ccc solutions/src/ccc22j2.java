 import java.util.*;

public class ccc22j2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int numberOfPlayers = sc.nextInt();
	    int starPlayers = 0;
	    for(int i = 0; i < numberOfPlayers*2; i++){
	      if(sc.nextInt()*5/(sc.nextInt()*3) > 40){
	        starPlayers++;
	      }
	    }
	    System.out.println(starPlayers);
	    if(starPlayers == numberOfPlayers){
	      System.out.print("+");
	    }
	}
}
