import java.util.*;
import java.io.*;

public class cc3p2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        String game = br.readLine();
       	int score = 0;
        int ammo = 0;
        int opponent = 0;
        
        for(int i = 0; i < N; i++) {
        	if(game.charAt(i) == 'F' && opponent > 0) opponent--;
        	else if(game.charAt(i) == 'F' && ammo > 0) {
        		score++; 
        		ammo--;
        	}
        	else if(game.charAt(i) == 'F' && ammo <= 0) {
        		ammo++;
        	}
        	else if(game.charAt(i) == 'B') ammo++;
        	else{
        		opponent++;
        		if(ammo > 0) {
            		ammo--;
            		score++;
        		}else ammo++;
        	}
        }
        
        out.println(score);
        out.flush();
    }

}