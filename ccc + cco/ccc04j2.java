import java.io.*;
import java.util.Scanner;

public class ccc04j2 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int firstYear = sc.nextInt();
         int secondYear = sc.nextInt();
         for(int i = firstYear; i <= secondYear; i = i + 60){
                System.out.println("All positions change in year " + i);
        }
    }
}