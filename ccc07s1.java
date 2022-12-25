import java.util.*;

public class ccc07s1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i  < n; i++) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int date = sc.nextInt(); 
            if(2007-year > 18) {
                System.out.println("Yes");
            } else if(2007-year==18 && month < 2) {
                System.out.println("Yes");
            } else if(2007-year==18 && month == 2 && date <= 27) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}