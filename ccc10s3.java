import java.util.*;
import java.io.*;

public class ccc10s3 { // i apologize for the unreadable code its the most straightforward approach i could think of
	
	static ArrayList<Integer> houses = new ArrayList<>();
	
	public static boolean possible(int range, int hydrants) {
		Deque<Integer> ans = new LinkedList<>();
		HashSet<Integer> satisfied = new HashSet<>();
		int temp = hydrants;
		int cur = 1;
		
		ans.add(houses.get(0)+range < 1000000 ? houses.get(0)+range : houses.get(0)+range-1000000);
		satisfied.add(houses.get(0));
		hydrants--;
		
		
		while(hydrants > 0 && cur < houses.size()) {
			if(Math.min(Math.abs(houses.get(cur)-ans.peekLast()), Math.abs(ans.peekLast()-1000000)+houses.get(cur)) > range) {
				ans.add(houses.get(cur)+range < 1000000 ? houses.get(cur)+range : houses.get(cur)+range-1000000);
				hydrants--;
			}
			satisfied.add(houses.get(cur));
			cur++;
		}

		for(int i = cur; i < houses.size(); i++) {
			if(Math.min(Math.abs(houses.get(i)-ans.peekLast()), Math.abs(ans.peekLast()-1000000)+houses.get(i)) <= range) {
				satisfied.add(houses.get(i));
			}
		}

		if(satisfied.size() == houses.size()) return true;
		
		
		ans = new LinkedList<>();
		satisfied = new HashSet<>();
		cur = houses.size()-1;
		hydrants = temp;
		
		ans.add(houses.get(0)-range >= 0 ? houses.get(0)-range : 1000000-Math.abs(houses.get(0)-range));
		satisfied.add(houses.get(0));
		hydrants--;
		
		
		while(hydrants > 0 && cur > 0) {
			if(Math.min(Math.abs(houses.get(cur)-ans.peekLast()), Math.abs(houses.get(cur)-1000000)+ans.peekLast()) > range) {
				ans.add(houses.get(cur)-range >= 0 ? houses.get(cur)-range : 1000000-Math.abs(houses.get(cur)-range));
				hydrants--;
			}
			
			satisfied.add(houses.get(cur));
			cur--;
		}

		for(int i = cur; i > 0; i--) {
			if(Math.min(Math.abs(houses.get(i)-ans.peekLast()), Math.abs(houses.get(i)-1000000)+ans.peekLast()) <= range) {
				satisfied.add(houses.get(i));
			}
		}
		
		if(satisfied.size() == houses.size()) return true;
		return false;
	}

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int H = Integer.parseInt(br.readLine());
        for(int i = 0; i < H; i++) houses.add(Integer.parseInt(br.readLine()));
        Collections.sort(houses);
        
        int K = Integer.parseInt(br.readLine());
        
        
        int high = 500000;
        int low = 0;
        int mid = (high+low)/2;
        int last = -1;
        
        while(mid != last) {
        	boolean cur = possible(mid, K);
        	last = mid;
        	
        	if(cur) {
        		high = mid;
        		mid = (high+low)/2;
        	}else {
        		low = mid;
        		mid = (high+low)/2;
        	}
        }
        
        out.println(high);
        out.flush();
    }

}