import java.util.*;

public class ccc03j2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner (System.in);
        while(true) {
            int c = sc.nextInt(); 
            if(c == 0) {
                break;
            }
            int arr[] = new int[c+1];
            for(int i = 1; i <= c; i++) {
                if(c%i == 0){
                    arr[i] = i;
                }
            }
            int a = Integer.MAX_VALUE;
            int l = 0;
            for(int i = 0; i <= c; i++) {
                if(arr[i] != 0) {
                    if(arr[i] * 2 + c / arr[i] * 2 < a) {
                        a = arr[i] * 2 + c / arr[i] * 2;
                        l = arr[i];
                    }
                }
            }
            System.out.println("Minimum perimeter is " + a + " with dimensions " + l + " x " + c / l);
        }
    }
}