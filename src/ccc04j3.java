import java.io.*;
import java.util.*;

public class ccc04j3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int thing1 = sc.nextInt(); //amount of adjectives
        int thing2 = sc.nextInt(); //number of nouns
        String adj[] = new String[thing1]; //an array for the adjectives
        String noun[] = new String[thing2]; //same for nouns
        for(int i = 0; i < thing1; i++){ //this for loop is to store every adjective in an array
            adj[i] = sc.next();
        }
        for(int i = 0; i < thing2; i++){ //same thing nouns
            noun[i] = sc.next();
        }
        for(int i = 0; i < thing1; i++){
          for(int j = 0; j < thing2; j++){
            System.out.println(adj[i] + " as " + noun[j]);
          }
        }
    }
}