import java.util.*;
public class flipper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String numberOfFlips = sc.next();
		int numberOfV = 0;
		int numberOfH = 0;
		for( int i = 0; i < numberOfFlips.length( ); i++ )
		{
		    if(numberOfFlips.charAt(i) == ('V')){
		    	numberOfV++;
		    }else {
		    	numberOfH++;
		    }
		}
		if(numberOfV%2 == 0){
			if(numberOfH%2 == 0) {
				System.out.println("1 2\r\n"
						         + "3 4");
			}
			if(numberOfH%2 == 1) {
				System.out.println("3 4\r\n"
				         		 + "1 2");
			}
		}else if(numberOfV%2 == 1) {
			if(numberOfH%2 == 0) {
				System.out.println("2 1\r\n"
								 + "4 3");
			}
			if(numberOfH%2 == 1) {
				System.out.println("4 3\r\n"
				         		 + "2 1");
			}
		}
		
	}

}
