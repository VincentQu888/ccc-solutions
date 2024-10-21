import java.util.*;

public class upAndDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		if(a-b > c-d){
			System.out.println("Nikky");
		}else if(c-d > a-b){
			System.out.println("Byron");
			}else{
				System.out.println("Tied");
		}
	}
}

