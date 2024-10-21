import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class coci10c3p5 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        BigInteger[] sequence = new BigInteger[N];
        int[] minl = new int[N], minr = new int[N], maxl = new int[N], maxr = new int[N];

        Deque<Integer> maxs = new LinkedList<>();
        Deque<Integer> mins = new LinkedList<>();

        for (int i = 0; i < N; ++i) {
            sequence[i] = new BigInteger(br.readLine());

            while (!maxs.isEmpty() && sequence[i].compareTo(sequence[maxs.peekLast()]) > 0) {
                maxr[maxs.pollLast()] = i;
            }
            if (!maxs.isEmpty()) maxl[i] = maxs.peekLast();
            maxs.add(i);

            while (!mins.isEmpty() && sequence[i].compareTo(sequence[mins.peekLast()]) < 0) {
                minr[mins.pollLast()] = i;
            }
            if (!mins.isEmpty()) minl[i] = mins.peekLast();
            mins.add(i);
        }

        for (int i = 0; i < N; ++i) {
            if (sequence[minr[i]].compareTo(sequence[i]) > 0 || minr[i] <= i) minr[i] = N;
            if (sequence[minl[i]].compareTo(sequence[i]) > 0 || minl[i] >= i) minl[i] = -1;
            if (sequence[maxr[i]].compareTo(sequence[i]) < 0 || maxr[i] <= i) maxr[i] = N;
            if (sequence[maxl[i]].compareTo(sequence[i]) < 0 || maxl[i] >= i) maxl[i] = -1;
        }

        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < N; ++i) {
            BigInteger firstTerm = BigInteger.valueOf(maxr[i] - i);
            BigInteger secondTerm = BigInteger.valueOf(i - maxl[i]);
            ans = ans.add(firstTerm.multiply(secondTerm).multiply(sequence[i]));

            firstTerm = BigInteger.valueOf(minr[i] - i);
            secondTerm = BigInteger.valueOf(i - minl[i]);
            ans = ans.subtract(firstTerm.multiply(secondTerm).multiply(sequence[i]));
        }

        System.out.println(ans);
    }
}
