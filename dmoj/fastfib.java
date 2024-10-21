import java.util.*;
import java.io.*;
import java.math.*;

public class fastfib {
	
	public static BigInteger[][] fib(BigInteger[][] b, BigInteger n){
	    if(n.equals(BigInteger.ONE)) return b;
	    
	    if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
	        BigInteger[][] temp = fib(b, n.divide(BigInteger.valueOf(2)));
	        return multiply(temp, temp);
	    }
	    else {
	        BigInteger[][] temp = fib(b, (n.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
	        temp = multiply(temp, temp);
	        return multiply(b, temp);
	    }
	}

	public static BigInteger[][] multiply(BigInteger[][] a, BigInteger[][] b){
	    BigInteger[][] ans = new BigInteger[2][2];
	    
	    ans[0][0] = (a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]))).mod(BigInteger.valueOf(1000000007));
	    ans[0][1] = (a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))).mod(BigInteger.valueOf(1000000007));
	    ans[1][0] = (a[0][0].multiply(b[1][0]).add(a[1][0].multiply(b[1][1]))).mod(BigInteger.valueOf(1000000007));
	    ans[1][1] = (a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))).mod(BigInteger.valueOf(1000000007));
	    return ans;
	}

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    BigInteger n = new BigInteger(br.readLine()).mod(new BigInteger("2000000016"));
	    BigInteger[][] b = new BigInteger[2][2];
	    b[0][0] = BigInteger.ONE; b[0][1] = BigInteger.ONE; b[1][0] = BigInteger.ONE; b[1][1] = BigInteger.ZERO;
	    
	    if(n.equals(BigInteger.ZERO)) System.out.println(0);
	    else if(n.equals(BigInteger.ONE)) System.out.println(1);
	    else {
	        b = fib(b, n.subtract(BigInteger.ONE));
	        System.out.println(b[0][0]);
	    }
	}
}