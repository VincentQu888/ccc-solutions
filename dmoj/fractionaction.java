import java.util.*;

public class fractionaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int numerator = sc.nextInt();
		int denominator = sc.nextInt();
		int gcd = 0;
		for(int i = 1; i <= numerator && i <= denominator; i++)
	        {
	            if(numerator%i==0 && denominator%i==0)
	                gcd = i;
	        }
		if(numerator < denominator) {
			System.out.println(numerator/gcd + "/" + denominator/gcd);
		}
		if(numerator > denominator) {
			for(int i = 1; numerator < denominator; i++) {
					numerator = numerator - denominator;
					if(numerator < denominator) {
						System.out.println(i + " " + numerator/gcd + "/" + denominator/gcd);
					}
				}
			}
		}
	}


