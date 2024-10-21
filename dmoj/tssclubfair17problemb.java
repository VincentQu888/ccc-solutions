import java.util.*;
import java.lang.Math;

public class tssclubfair17problemb {

	public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
          @Override              
          public int compare(final int[] entry1, 
                             final int[] entry2) {
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });  
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int houses = sc.nextInt();
			int queries = sc.nextInt();
			int houseCoordinates[][] = new int[houses][2];
			int scenarios[] = new int[queries];
			int counter = 0;
			for(int i = 0; i < houses; i++) {
				for(int j = 0; j < 2; j++) {
					houseCoordinates[i][j] = sc.nextInt();
				}
				sortbyColumn(houseCoordinates, 0);
			}
			for(int i = 0; i < queries; i++) {
				scenarios[i] = sc.nextInt();
			}
			for(int i = 0; i < queries; i++) {
				while(Math.sqrt(houseCoordinates[counter][0]^2+houseCoordinates[counter][1]^2) <= scenarios[i] || counter == houses) {
					System.out.println(houseCoordinates[counter][0]^2+houseCoordinates[counter][1]^2 + scenarios[i]);
					counter++;
				}
			}
	}

}
