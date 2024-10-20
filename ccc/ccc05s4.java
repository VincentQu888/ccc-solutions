import java.util.*;
import java.io.*;

public class ccc05s4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		int L = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < L; i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, ArrayList<String>> graph = new HashMap<>();
			Queue<String> queue = new LinkedList<>();
			HashMap<String, Boolean> visited = new HashMap<>();
			HashMap<String, Integer> step = new HashMap<>();
			String start = "a";
			int counter1 = 0;
			int counter2 = 0;
			String[] firstinputs = new String[n/2];
			String[] secondinputs = new String[n/2];
			
			for(int j = 0; j < n/2; j++) {
				String input1 = br.readLine();
				String input2 = br.readLine();
				graph.put(input1, new ArrayList<>());
				graph.put(input2, new ArrayList<>());
				visited.put(input1, false);
				visited.put(input2, false);
				step.put(input1, 0);
				step.put(input2, 0);
				firstinputs[j] = input1;
				secondinputs[j] = input2;
			}
			for(int j = 0; j < n/2; j++) {
				graph.get(firstinputs[j]).add(secondinputs[j]);
				graph.get(secondinputs[j]).add(firstinputs[j]);
			}
			
			start = secondinputs[secondinputs.length-1];
			queue.add(start);
			visited.put(start, true);
			
			while(!queue.isEmpty()){
				
				String current = queue.poll();
				
				for(int j = 0; j < graph.get(current).size(); j++) {
					if(!visited.get(graph.get(current).get(j))) {
						queue.add(graph.get(current).get(j));
						visited.put(graph.get(current).get(j), true);
						step.put(graph.get(current).get(j), step.get(current)+1);
						if(step.get(graph.get(current).get(j)) > counter2) {
							counter2 = step.get(graph.get(current).get(j));
						}
						counter1++;
					}
				}
			}
			out.println(counter1*20 - counter2*20);
			
		}
		out.flush();
	}

}
