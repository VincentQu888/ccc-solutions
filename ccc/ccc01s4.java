import java.util.*;
import java.io.*;

public class ccc01s4 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		double[] x = new double[n];
		double[] y = new double[n];
		double largest = 0;
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					double a = Math.sqrt((x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]));
					double b = Math.sqrt((x[i]-x[k])*(x[i]-x[k]) + (y[i]-y[k])*(y[i]-y[k]));
					double c = Math.sqrt((x[k]-x[j])*(x[k]-x[j]) + (y[k]-y[j])*(y[k]-y[j]));
					double semiperimeter = (a+b+c)/2;
					double d = 0;
				    if ((semiperimeter == 0) || (a * a + b * b - c * c < 0) || (b * b + c * c - a * a < 0) || (c * c + a * a - b * b < 0)) {
				    	if (a > d) {
				    		d = a;
				    	}
				    	if (b > d) {
				    		d = b;
				    		}
				    	if (c > d) {
				    		d = c;
				    	}
				    }else{
				    	d = 2*a*b*c/(4*Math.sqrt(semiperimeter*(semiperimeter-a)*(semiperimeter-b)*(semiperimeter-c)));
				    }
				    if (d > largest) {
				    	largest = d;	
				    }
				}
			}
		}
		System.out.format("%.2f", largest);
		
	}

}
