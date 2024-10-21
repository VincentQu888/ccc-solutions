
public class gwcc3tiebreaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = (int)(Math.random()*20);
		System.out.println(N + " " + (int)(Math.random()*5000));
		
		for(int i = 0; i < N; ++i) {
			System.out.print((int)(Math.random()*500) + " ");
		}
	}

}
