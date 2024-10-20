import java.util.*;

public class ccc16j3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        boolean found=false;
        for(int length=s.length();length>=1;length--){
            for(int i=0;i<=s.length()-length;i++){
                if(isP(s.substring(i,i+length))){
                    found=true;
                    System.out.println(length);
                    break;
                }
            }
            if(found){
                break;
            }
        }
    }
    public static boolean isP(String s){
        boolean p=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                p=false;
            }
        }return p;
    }
}