import java.util.*;
import java.io.*;

public class coci13c5p3 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        String explosion = br.readLine();
        Deque<Character> stack = new LinkedList<>();
        stack.add(' ');
        
        for(int i = 0; i < str.length(); ++i) {
        	stack.add(str.charAt(i));
        	
        	int counter = explosion.length()-1;
        	boolean remove = false;
        	Iterator<Character> iterator = stack.descendingIterator();
        	while(iterator.hasNext()) {
        		if(counter < 0) {
        			remove = true;
        			break;
        		}
        		
        		if(iterator.next() != explosion.charAt(counter)) break;
        		else --counter;
        	}
        	
        	if(remove) {
        		for(int j = 0; j < explosion.length(); ++j) stack.removeLast();
        	}
        }
        
        
        if(stack.size() == 1) System.out.println("FRULA");
        else {
        	Deque<Character> ans = new LinkedList<>();
        	while(stack.size() > 1) ans.add(stack.pollLast());
        	while(!ans.isEmpty()) System.out.print(ans.pollLast());;
        }
        
    }

}