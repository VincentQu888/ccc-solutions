import java.util.*;

public class codingBatJavaRecursion1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
			System.out.println(factorial(n));
	}
	public static long factorial(long n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return n*factorial(n-1);
	}
}
