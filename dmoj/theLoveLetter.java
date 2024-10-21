import java.io.*;

public class theLoveLetter {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int shifts = Integer.parseInt(br.readLine());
		char letter[] = new char[length];
		while(shifts > 26) {
			shifts -= 26;
		}
		for(int i = 0; i < length; i++) {
			letter[i] = (char)br.read();
		}
		for(int i = 0; i < length; i++) {
			int ascii = (int)letter[i];
			if(ascii == 32) {}
			else if(ascii + shifts <= 122) {
				ascii += shifts;
			}else {
				ascii = ascii+shifts-26;
			}
			letter[i] = (char) ascii;
		}
		for(int i = 0; i < length; i++) {
			System.out.print(letter[i]);
		}
	}

}
