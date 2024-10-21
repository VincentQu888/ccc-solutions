import java.util.*;

public class slotMachines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		int quarters = sc.nextInt();
		int machines[] = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		while(quarters > 0) {
			quarters--;
			machines[0]+=1;
			counter++;
			if(machines[0]%35 == 0) {
				quarters+=30;
			}
			if(quarters == 0) {
				System.out.println("Martha plays " + counter + " times before going broke.");
			}
			quarters--;
			machines[1]+=1;
			counter++;
			if(machines[1]%100 == 0) {
				quarters+=60;
			}
			if(quarters == 0) {
				System.out.println("Martha plays " + counter + " times before going broke.");
			}
			quarters--;
			machines[2]+=1;
			counter++;
			if(machines[2]%10 == 0) {
				quarters+=9;
			}
			if(quarters == 0) {
				System.out.println("Martha plays " + counter + " times before going broke.");
			}
		}
	}

}