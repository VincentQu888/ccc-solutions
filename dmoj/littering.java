import java.util.*;

public class littering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int pieces = sc.nextInt();
		int maxPieces = sc.nextInt();
		int maxFilthiness = 0;
		int garbage[] = new int[pieces];
		for(int i = 0; i < pieces; i++) {
			garbage[i] = sc.nextInt();
		}
		Arrays.sort(garbage);
		for(int i = 0; i < maxPieces; i++) {
			maxFilthiness+=garbage[pieces-1-i];
		}
		System.out.println(maxFilthiness);
	}
}
