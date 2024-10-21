import java.util.*;

public class FloorPlan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int amountOfTiles = sc.nextInt();
		int rows = sc.nextInt();
		int coloumns = sc.nextInt();
		int arr[][] = new int [rows][coloumns];
		for(int ii = 0; ii < rows; ii++) {
			for(int i = 0; i < coloumns; i++) {
				arr[ii][i] = sc.nextInt();
			}
		}
		for(int i = 0; i < amountOfTiles; i++) {
			
		}
	}

}
