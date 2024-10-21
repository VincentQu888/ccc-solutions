import java.util.*;

public class figureSkatingFun {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int competitors = sc.nextInt();
		int high = competitors-1;
		int low = 0;
		int mid = (low+high)/2;
		int sum1 = 0;
		int sum2 = 0;
		boolean loop = false;
		int scores[] = new int[competitors];
		for(int i = 0; i < competitors; i++) {
			scores[i] = sc.nextInt();
		}		
		while(loop = false) {
			for(int i = 0; i < mid; i++) {
				sum1 += scores[i];
			}
			for(int i = mid; i < high; i++) {
				sum2 += scores[i];
			}
			if(mid == high) {
				loop = true;
				System.out.println("Andrew is sad.");
			}
			else if(sum1 == sum2) {
				loop = true;
				System.out.println(mid-1);
			}else if(sum1 > sum2){
				high = mid;
				mid = (low+high)/2;
			}else {
				low = mid;
				mid = (low+high)/2;
			}
		}
	}
}
