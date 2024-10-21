import java.util.*;

public class gwcc2p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = (int)(58);
		int M = (int)(57);
		System.out.println(N + " " + M);
		for(int i = 0; i < N; i++) {
			System.out.println((char)(i+'A'));
		}
		for(int i = 0; i < M; i++) {
			System.out.println((char)(i+'A') + " " + (char)(i+'A'+1));
		}
	}

}
