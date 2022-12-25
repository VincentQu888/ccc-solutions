import java.io.*;
import java.util.*;

public class ccc20s2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[M+1][N+1];
        Queue<Integer> queuex = new LinkedList<>();
        Queue<Integer> queuey = new LinkedList<>();
        boolean[][] visited = new boolean[M+1][N+1];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < 1000001; i++) {
        	adj.add(new ArrayList<>());
        }
        
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
          for(int j = 1; j <= N ; j++){
            graph[i][j] = Integer.parseInt(st.nextToken());
            adj.get(i*j).add(new int[] {i, j});
          }
        }
        

        queuex.add(1);
        queuey.add(1);
        visited[1][1] = true;

        while(!queuex.isEmpty()){
          int currentx = queuex.poll();
          int currenty = queuey.poll();
          if(currentx == M && currenty == N) {
        	out.println("yes");
        	out.flush();
        	System.exit(0);
          }
          
          if(adj.get(graph[currentx][currenty]) != null) {
        	  for(int i = 0; i < adj.get(graph[currentx][currenty]).size(); i++){
            	  if(!visited[adj.get(graph[currentx][currenty]).get(i)[0]][adj.get(graph[currentx][currenty]).get(i)[1]]) {
                	  queuex.add(adj.get(graph[currentx][currenty]).get(i)[0]);
                	  queuey.add(adj.get(graph[currentx][currenty]).get(i)[1]);
                	  visited[adj.get(graph[currentx][currenty]).get(i)[0]][adj.get(graph[currentx][currenty]).get(i)[1]] = true;  
            	  }
              }
          }
        }
        
        if(!visited[M][N]){
          out.println("no");
        }
        out.flush();
    }
}