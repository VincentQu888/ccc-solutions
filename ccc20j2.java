import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int N = sc.nextInt();
        int R = sc.nextInt();
        int newlyInfected = N*R;
        int ans = 0;
        
        while(N <= P){
            N += newlyInfected;
            newlyInfected *= R; 
            ans++;
        }
      System.out.println(ans);
    }
}
