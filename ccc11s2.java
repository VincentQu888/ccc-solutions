import java.util.*;

public class ccc11s2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int amountOfAnswers = sc.nextInt();
		int amountOfCorrectAnswers = 0;
		ArrayList<String> testAnswers = new ArrayList<String>();
		ArrayList<String> testActualAnswers = new ArrayList<String>();
		for(int i = 0; i < amountOfAnswers; i++) {
			testAnswers.add(sc.next());
		}
		for(int i = 0; i < amountOfAnswers; i++) {
			testActualAnswers.add(sc.next());
			if(testActualAnswers.get(i).equals(testAnswers.get(i))) {
				amountOfCorrectAnswers++;
			}
		}
		System.out.println(amountOfCorrectAnswers);
	}

}