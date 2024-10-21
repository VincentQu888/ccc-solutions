import java.util.*;

public class foodPlan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int randomNumber;
		int dayOfDumplingSoup = -1;
	    ArrayList<String> breakfast = new ArrayList<String>(Arrays.asList("Cereal and milk", "Eggs (fried, scrambled or boiled), and bread", "Porridge", "Eggs and salad", "Pancakes/waffles", "Yogurt and cereal", "Oatmeal", "Croissants"));
	    ArrayList<String> lunch = new ArrayList<String>(Arrays.asList("Egg fried rice", "Scrambled egg and tomato with noodles", "Rice with vegetables", "Udon noodles", "Taco", "Pizza", "Burger"));
	    ArrayList<String> dinner = new ArrayList<String>(Arrays.asList("Shrimp", "Chicken from costco", "Pork", "Beef", "Dumplings", "Fish", "Lamb", "Veggies"));
	    String lunchThisWeek[] = new String[7];
		String dayOfWeek[] = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
		for(int i = 0; i < 7; i++) {
			Random rand = new Random();
			randomNumber = rand.nextInt(8-i);
			System.out.println("Breakfast on "+dayOfWeek[i]+" will be "+breakfast.get(randomNumber)+".");
			breakfast.remove(randomNumber);
		}
		for(int i = 0; i < 7; i++) {
			Random rand = new Random();
			randomNumber = rand.nextInt(8-i);
			if(dinner.get(randomNumber).equals("Dumplings")) {
				dayOfDumplingSoup = i+1;
				if(dayOfDumplingSoup > 6) {
					dayOfDumplingSoup = 0;
				}
			}
			lunchThisWeek[i] = dinner.get(randomNumber);
			dinner.remove(randomNumber);
		}
		for(int i = 0; i < 7; i++) {
			Random rand = new Random();
			randomNumber = rand.nextInt(7-i);
			if(i == dayOfDumplingSoup) {
				System.out.println("Lunch on "+dayOfWeek[i]+" will be dumpling soup.");
			}else{
				System.out.println("Lunch on "+dayOfWeek[i]+" will be "+lunch.get(randomNumber)+".");
				lunch.remove(randomNumber);	
			}
		}
		for(int i = 0; i < 7; i++) {
			System.out.println("Dinner on "+dayOfWeek[i]+" will be "+lunchThisWeek[i]+".");
		}
	}
}
