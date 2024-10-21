import java.util.*;

public class zeroThatOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Amount of dollar amounts: ");
		int numberOfIntegers = sc.nextInt();
		int finalAmount[] = new int [numberOfIntegers];
		for(int i = 0; i < numberOfIntegers; i++) {
			int iThree = i+1;
			System.out.println("Dollar Earnings Number " + iThree + ": ");
			finalAmount[i] = sc.nextInt();
			if(finalAmount[i] == 0) {
				int iTwo = i;
				while(finalAmount[iTwo] == 0) {
					iTwo--;
				}
				finalAmount[iTwo] = 0;
			}
		}
		int finalAmountValue = 0;
		for(int i = -1; i < numberOfIntegers-1; i++) {
			finalAmountValue = finalAmountValue +finalAmount[i+1];
		}
		System.out.println("Total Amount Earned: " + finalAmountValue);

	}

}
