import java.util.Scanner;

public class ccc09j2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int trout = sc.nextInt();
        int pike = sc.nextInt();
        int pickerel = sc.nextInt();
        int limit = sc.nextInt();
        int ans = 0;
        for(int i = 0; i < limit/trout + 1; i++) {
            for(int j = 0; j < limit/pike + 1; j++) {
                for(int k = 0; k < limit/pickerel + 1; k++) {
                    if(trout*i+pike*j+pickerel*k<=limit&&(i!=0||j!=0||k!=0)) {
                        System.out.println(i + " Brown Trout, " + j + " Northern Pike, " + k + " Yellow Pickerel");
                        ans++;
                    }
                }
            }
        }System.out.println("Number of ways to catch fish: " + ans);
    }

}