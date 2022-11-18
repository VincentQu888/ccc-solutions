import java.util.*;

public class ccc22s1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int finnsNumber = sc.nextInt();
	    int answer = 0;
	    for(int i = 0; i < finnsNumber; i++){
	      if((finnsNumber-i*5)%4 == 0){
	        answer++;
	      }
	    }    
	    System.out.println(answer);
	}

}
