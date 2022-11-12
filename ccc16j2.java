import java.io.*;
import java.util.*;

public class ccc16j2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean magic = true;
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum = sum + arr[0][i];
        }
        for(int i = 1; i < 4; i++){
            int newSum = 0;
            for(int j = 0; j < 4; j++){
                newSum = newSum + arr[i][j];
            }
            if(newSum == sum){
            }else{
                magic = false;
            }
        }for(int i = 0; i < 4; i++){
            int newSum = 0;
            for(int j = 0; j < 4; j++){
                newSum = newSum + arr[j][i];
            }
            if(newSum == sum){
            }else{
                magic = false;
            }
        }
        if(magic == true){
            System.out.println("magic");
        }else{
            System.out.println("not magic");
        }
    }
}