import java.util.*;

public class pictureperfect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		while(true) {
	         int b = sc.nextInt();
	         if(b == 0) {
	             break;
	            }
		int c = sc.nextInt(); 
		int arr[] = new int[c];
		for(int i = 0; i <= c; i++) {
			if(c%i == 0){
				arr[i] = i;
				}
			}
		int a = arr[2];
		System.out.println("Minimum perimeter is" + (a * 2 + c / a * 2) + "with dimensions" + a + " x " + c / a);
		}
	}
}
