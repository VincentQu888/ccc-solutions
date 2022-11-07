import java.io.*;
import java.util.*;

public class ccc11j3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstInt = sc.nextInt();
        int secondInt = sc.nextInt();
        int i = 2;
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(firstInt);
        sequence.add(secondInt);
        sequence.add(sequence.get(i-2) - sequence.get(i-1)); 
        while(sequence.get(i-1) >= sequence.get(i)){
            i++;
            sequence.add(sequence.get(i-2) - sequence.get(i-1)); 
        }
        System.out.println(sequence.size());
    }
}