import java.util.*;

public class modernArt {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arrlengthone = sc.nextInt();
		int arrlengthtwo = sc.nextInt();
		int numberOfStrokes = sc.nextInt();
		int numberOfGold = 0;
		int arr[][] = new int[arrlengthone][arrlengthtwo];
		for(int i = 0; i < arrlengthone; i++) {
			for(int j = 0; j < arrlengthone; j++) {
				arr[i][j] = 0;
			}
		}
		for(int i = 0; i < numberOfStrokes; i++) {
			if(sc.next().contains("C")) {
				int a = sc.nextInt()-1;
				for(int j = 0; j < arrlengthone; j++) {
					if(arr[j][a] == 1) {
						arr[j][a] = 0;
					}else{
						arr[j][a] = 1;
					}
				}
			}else{
				int a = sc.nextInt()-1;
				for(int j = 0; j < arrlengthtwo; j++) {
					if(arr[a][j] == 1) {
						arr[a][j] = 0;
					}else {
						arr[a][j] = 1;
					}
				}
			}
		}
		for(int i = 0; i < arrlengthone; i++) {
			for(int j = 0; j < arrlengthtwo; j++) {
				if(arr[i][j] == 1) {
					numberOfGold++;
				}
			}
		}
		System.out.println(numberOfGold);
	}
}
