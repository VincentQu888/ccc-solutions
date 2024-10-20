import java.util.Scanner;

public class ccc02j2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while(true) {
            String a = sc.next();//if a ever becomes "quit!" then we will exit the program
            if(a.equals("quit!") == true) {
                break;
            }
            int length = a.length();
            char char1 = a.charAt(length - 3);
            String b = a.substring(0, length - 1);
            if(length >= 4 && a.charAt(length - 1) == 'r' && a.charAt(length - 2) == 'o' && char1 != 'a' && char1 != 'e' && char1 != 'i' && char1 != 'o' && char1 != 'u' && char1 != 'y'){//checking if o and r are the last ones
                System.out.println(b + "ur");
            }else {
                System.out.println(a);
            }
        }
    }
}