import java.util.*;

public class rhymeOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("First line: ");
		String firstLine = sc.nextLine();
		System.out.println("Second line: ");
		String secondLine = sc.nextLine();
		String firstRhyme;
		String secondRhyme;
		int lastWordOne = firstLine.lastIndexOf(" ");
		int lastWordTwo = secondLine.lastIndexOf(" ");
		int firstRhymeOne = firstLine.lastIndexOf("a");
		int firstRhymeTwo = firstLine.lastIndexOf("e");
		int firstRhymeThree = firstLine.lastIndexOf("i");
		int firstRhymeFour = firstLine.lastIndexOf("o");
		int firstRhymeFive = firstLine.lastIndexOf("u");
		int firstRhymeSix = firstLine.lastIndexOf("y");
		int secondRhymeOne = secondLine.lastIndexOf("a");
		int secondRhymeTwo = secondLine.lastIndexOf("e");
		int secondRhymeThree = secondLine.lastIndexOf("i");
		int secondRhymeFour = secondLine.lastIndexOf("o");
		int secondRhymeFive = secondLine.lastIndexOf("u");
		int secondRhymeSix = secondLine.lastIndexOf("y");
		int firstRhymeLocation = Math.max(firstRhymeOne, Math.max(firstRhymeTwo, Math.max(firstRhymeThree, Math.max(firstRhymeFour, Math.max(firstRhymeFive, firstRhymeSix)))));
		int secondRhymeLocation = Math.max(secondRhymeOne, Math.max(secondRhymeTwo, Math.max(secondRhymeThree, Math.max(secondRhymeFour, Math.max(secondRhymeFive, secondRhymeSix)))));
		if(firstRhymeLocation < lastWordOne) {
			firstRhyme = firstLine.substring(lastWordOne, firstLine.length());
		}else {
			firstRhyme = firstLine.substring(firstRhymeLocation, firstLine.length());
		}
		if(secondRhymeLocation < lastWordTwo) {
			secondRhyme = secondLine.substring(lastWordTwo, secondLine.length()); 
		}else {
			secondRhyme = secondLine.substring(secondRhymeLocation, secondLine.length());
		}
		if(firstRhyme.equals(secondRhyme)){
			System.out.println("The two lines rhyme");
		}else {
			System.out.println("The two lines do not rhyme");
		}
	}
}
