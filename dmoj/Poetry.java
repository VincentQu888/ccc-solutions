import java.util.*;

public class Poetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int verses = sc.nextInt();
		sc.nextLine();
		int iii = 0;
		int rhymeWhere[] = new int[verses*4];
		String lines[][] = new String [verses][4];
		for(int i = 0; i < verses; i++) {
			for(int ii = 0; ii < 4; ii++) {
				lines[i][ii] = sc.nextLine();
				rhymeWhere[iii] = Math.max(lines[i][ii].lastIndexOf("a"), Math.max(lines[i][ii].lastIndexOf("e"), Math.max(lines[i][ii].lastIndexOf("i"), Math.max(lines[i][ii].lastIndexOf("o"), Math.max(lines[i][ii].lastIndexOf("u"), Math.max(lines[i][ii].lastIndexOf("y"), lines[i][ii].lastIndexOf(" ")))))));	
				iii++;
			}
		}
		for(int i = 0; i < verses; i++) {
			if(lines[i][0].substring(rhymeWhere[0+i*4], lines[i][0].length()).equals(lines[i][1].substring(rhymeWhere[1+i*4], lines[i][1].length()))&&lines[i][0].substring(rhymeWhere[0+i*4], lines[i][0].length()).equals(lines[i][2].substring(rhymeWhere[2+i*4], lines[i][2].length()))&&lines[i][0].substring(rhymeWhere[0+i*4], lines[i][0].length()).equals(lines[i][3].substring(rhymeWhere[3+i*4], lines[i][3].length()))){
				System.out.println("perfect");
			}
			else if(lines[i][0].substring(rhymeWhere[0+i*4], lines[i][0].length()).equals(lines[i][1].substring(rhymeWhere[1+i*4], lines[i][1].length()))&&lines[i][2].substring(rhymeWhere[2+i*4], lines[i][2].length()).equals(lines[i][3].substring(rhymeWhere[3+i*4], lines[i][3].length()))){
				System.out.println("even");
			}
			else if(lines[i][0].substring(rhymeWhere[0+i*4], lines[i][0].length()).equals(lines[i][2].substring(rhymeWhere[2+i*4], lines[i][2].length()))&&lines[i][1].substring(rhymeWhere[1+i*4], lines[i][1].length()).equals(lines[i][3].substring(rhymeWhere[3+i*4], lines[i][3].length()))){
				System.out.println("cross");
			}
			else if(lines[i][0].substring(rhymeWhere[0+i*4], lines[i][0].length()).equals(lines[i][3].substring(rhymeWhere[3+i*4], lines[i][3].length()))&&lines[i][1].substring(rhymeWhere[1+i*4], lines[i][1].length()).equals(lines[i][2].substring(rhymeWhere[2+i*4], lines[i][2].length()))){
				System.out.println("shell");
			}else {
				System.out.println("free");
			}
		}
	}
}
