import java.util.*;
import java.io.*;

public class ccc21j3 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String command = "a";
		String direction = "right";
		
		while(!command.equals("99999")) {
			command = br.readLine();
			if(command.equals("99999")) {
				break;
			}else if((Character.getNumericValue(command.charAt(0)) + Character.getNumericValue(command.charAt(1)))%2 == 1){
				direction = "left";
				System.out.println(direction + " " + command.substring(2));
			}else if((Character.getNumericValue(command.charAt(0)) + Character.getNumericValue(command.charAt(1)))%2 == 0 && Character.getNumericValue(command.charAt(0)) + Character.getNumericValue(command.charAt(1)) != 0) {
				direction = "right";
				System.out.println(direction + " " + command.substring(2));
			}else{
				System.out.println(direction + " " + command.substring(2));
			}
		}
	}

}
