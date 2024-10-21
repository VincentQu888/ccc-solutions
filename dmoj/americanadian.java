import java.util.*;

public class americanadian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			String a = sc.next();
			int length = a.length();
			int length2 = a.lastIndexOf("o");
			int length3 = a.lastIndexOf("r");
			char char1 = a.charAt(length - 2);
			
			if(length > 4 && length2 == length - 1 && length3 == length && char1 == 'a'){
				System.out.println("ur");
			}
	}

}
