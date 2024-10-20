import java.util.*;

public class ccc21j1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int B = sc.nextInt();
		
		System.out.println(5*B-400);
		if(5*B-400 == 100) {
			System.out.println(0);
		}else if(5*B-400 > 100) {
			System.out.println(-1);
		}else {
			System.out.println(1);
		}
	}

}
