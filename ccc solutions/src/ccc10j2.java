import java.util.*;

public class ccc10j2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), s = sc.nextInt();
        int nikky = (s/(a+b))*(a-b);
        if(s%(a+b)>a){
            nikky=nikky-s%(a+b)+a;
        }else{
            nikky+=s%(a+b);
        }
        int byron = (s/(d+c))*(c-d);
        if(s%(c+d)>c){
            byron=byron-s%(c+d)+c;
        }else{
            byron+=s%(c+d);
        }if(byron>nikky){
            System.out.println("Byron");
        }else if(nikky>byron){
            System.out.println("Nikky");
        }else{
            System.out.println("Tied");
        }
    }
}