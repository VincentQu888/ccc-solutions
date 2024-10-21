import java.util.*;

public class amazonprices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//You are the developer for amazon and you have a catalog of items stored into an arraylist with a price and a name. Write a program that will allow the user to sort the items from lowest to highest price
		Scanner sc = new Scanner (System.in);
		int amountOfItems = sc.nextInt();
		int arr[] = new int[amountOfItems]; 
		 HashMap<String, Integer> itemAndPrice = new HashMap<String, Integer>();
		 	for(int i = 0; i < amountOfItems; i++) {
		 	itemAndPrice.put(sc.next(), sc.nextInt()); 
		 }
		 	for(int i = 0; i < amountOfItems; i++) {
		 		arr[i] = itemAndPrice.get(i);
		 	}
		 	Arrays.sort(arr);

	}
}
