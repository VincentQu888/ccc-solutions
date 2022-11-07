import java.util.*;

public class ccc22j1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int largeBoxes = sc.nextInt();
	    int smallBoxes = sc.nextInt();
	    System.out.println((largeBoxes*8+smallBoxes*3)%28);
	}

}
