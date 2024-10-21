
import java.util.*;

public class gwcc2p5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = (int)(Math.random()*15+1);
		int M = (int)(Math.random()*+4);
		System.out.println(N + " " + M);
		
		for(int i = 0; i < N; i++) {
			System.out.println((int)(Math.random()*M+1) + " " + (int)(Math.random()*5+1));
		}
	}

}
