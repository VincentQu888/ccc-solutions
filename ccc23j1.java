import java.util.*;
import java.io.*;

public class ccc23j1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in); 
        
        int C = input.nextInt();
        
        
        int P = input.nextInt();
        
        int result = (C*50)-(P*10);
        if(C>P){
            result = (C*50)-(P*10) + 500;
        }
        System.out.println(result);
        
            
    }

}