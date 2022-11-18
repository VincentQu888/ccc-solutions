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
        
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
          for(int j = 1; j <= N ; j++){
            graph[i][j] = Integer.parseInt(st.nextToken());
          }
        }

        queuex.add(M);
        queuey.add(N);
        visited[M][N] = true;

        while(!queuex.isEmpty()){
          int currentx = queuex.poll();
          int currenty = queuey.poll();

          for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
              if(graph[i][j] == currentx*currenty && !visited[i][j]){
                visited[i][j] = true;
                queuex.add(i);
                queuey.add(j);
              }
            }
          }
          if(visited[1][1]){
            out.println("yes");
            break;
          }
        }
        if(!visited[1][1]){
          out.println("no");
        }
        out.flush();
    }
}