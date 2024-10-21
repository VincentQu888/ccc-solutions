import java.util.*;

public class higherOrLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int randomNumber = rand.nextInt(101);
		int guess = -1;
		int i = 1;
		System.out.println("Guess an integer between 0 and 100: ");
		while(guess != randomNumber) {
			System.out.println("Guess " + 1 + ":");
			i++;
			guess = sc.nextInt();
			if(guess > randomNumber) {
				System.out.println("Lower");
			}
			if(guess < randomNumber) {
				System.out.println("Higher");
			}
			if(guess == randomNumber) {
				System.out.println("u got the number gg ez");
			}
		}
	}
}
