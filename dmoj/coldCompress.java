import java.util.*;

public class coldCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arrlength = sc.nextInt();
		int numberOfCharacters = 1;
		String arr[] = new String [arrlength];
		for(int i = 0; i < arrlength; i++) {
			arr[i] = sc.next();
		}
		for(int i = 0; i < arrlength; i++) {
			for(int j = 0; j < arr[i].length()-1; j++) {
				if(arr[i].charAt(j) == arr[i].charAt(j+1)) {
					numberOfCharacters++;
					if(j == arr[i].length()-2) {
						System.out.print(numberOfCharacters + " " + arr[i].charAt(j) + " ");
						numberOfCharacters = 1;
					}
				}else if(j == arr[i].length()-2) {
					System.out.print(1 + " " + arr[i].charAt(j+1) + " ");
					numberOfCharacters = 1;
				}else {
					System.out.print(numberOfCharacters + " " + arr[i].charAt(j) + " ");
					numberOfCharacters = 1;
				}
			}
			System.out.println();
		}
	}

}
