import java.util.*;
import java.io.*;

public class sac22c5p3 {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    HashSet<String>[] lists = new HashSet[N];
    for(int i = 0; i < N; i++){
      lists[i] = new HashSet<String>();
    }

    for(int i = 0; i < Q; i++){
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      int listn = Integer.parseInt(st.nextToken());
      String input = st.nextToken();

      if(command == 1){
        if(lists[listn-1] != null){
          if(lists[listn-1].contains(input)){
            out.println(1);
          }else{
            out.println(0);
          }
        }else{
        	out.println(0);
        }  
      }else{
        lists[listn-1].add(input);
      }
    }
    out.flush();
  }
}