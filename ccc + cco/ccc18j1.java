import java.util.*;

public class ccc18j1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr [] = new int[4];
		for(int i = 0; i < 4; i++){
			arr[i] = sc.nextInt();
		}
		if((arr[0] == 8 || arr[0] == 9)&&arr[1] == arr[2]&&(arr[3] == 8 || arr[3] == 9)){
			System.out.println("ignore");
		}else{
			System.out.println("answer");
		}
    
	}
  
}