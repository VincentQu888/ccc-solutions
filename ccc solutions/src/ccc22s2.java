import java.util.*;

public class ccc22s2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int violations = 0;
	    int x = sc.nextInt();
	    String goodGroups[][] = new String[x][2];
	    for(int i = 0; i < x; i++){
	      goodGroups[i][0] = sc.next();
	      goodGroups[i][1] = sc.next();
	    }
	    int y = sc.nextInt();
	    String badGroups[][] = new String [y][2];
	    for(int i = 0; i < y; i++){
	      badGroups[i][0] = sc.next();
	      badGroups[i][1] = sc.next();
	    }
	    int g = sc.nextInt();
	    String groups[][] = new String [g][3];
	    for(int i = 0; i < g; i++){
	      groups[i][0] = sc.next();
	      groups[i][1] = sc.next();
	      groups[i][2] = sc.next();
	    }
	    for(int i = 0; i < x; i++){
	      for(int j = 0; j < g; j++){
	         if(groups[j][0].contains(goodGroups[i][0]) || groups[j][1].contains(goodGroups[i][0]) || groups[j][2].contains(goodGroups[i][0]) && groups[j][0].contains(goodGroups[i][1]) || groups[j][1].contains(goodGroups[i][1]) || groups[j][2].contains(goodGroups[i][1])){
	      }else if(groups[j][0].contains(goodGroups[i][0]) || groups[j][1].contains(goodGroups[i][0]) || groups[j][2].contains(goodGroups[i][0])){
	        violations++;
	        }
	      }
	    }
	    for(int i = 0; i < y; i++){
	      for(int j = 0; j < g; j++){
	           if(groups[j][0].contains(badGroups[i][0]) || groups[j][1].contains(badGroups[i][0]) || groups[j][2].contains(badGroups[i][0]) && groups[j][0].contains(badGroups[i][1]) || groups[j][1].contains(badGroups[i][1]) || groups[j][2].contains(badGroups[i][1])){
	        violations++;
	        }
	      }
	    }
	    System.out.println(violations);
	}

}
