import java.util.*;

public class ccc20j2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int N = sc.nextInt();
		int R = sc.nextInt();
		int ans = 0;
		
		while(N < P) {
			N += Math.pow(R, ans);
			ans++;
		}
		
		System.out.println(ans);
	}

}
