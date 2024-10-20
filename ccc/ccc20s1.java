import java.util.Arrays;
import java.util.Scanner;

public class ccc20s1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        measure[] s = new measure[n];
        for(int i = 0; i < n; i++) {
            int ac = sc.nextInt();
            int bc = sc.nextInt();
            s[i] = new measure(ac, bc);
        }
        Arrays.sort(s);
        double max = 0;
        for(int i = 0; i < n-1; i++) {
            double dist = Math.abs(s[i+1].ds-s[i].ds);
            double time = Math.abs(s[i+1].ts-s[i].ts);
            max = Math.max(dist/time, max);
        }System.out.println(max);
    }

}
class measure implements Comparable<measure>{
    int ts;
    int ds;
    measure(int T, int D){
        ts = T;
        ds = D;
    }
    @Override
    public int compareTo(measure o) {
        // TODO Auto-generated method stub
        return this.ts-o.ts;
    }
}