package alltests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FailedToy {

	public static void main(String[] args) throws IOException {
		
		 BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		 String one = reader.readLine();
		 String two = reader.readLine(); 
		 String three = reader.readLine(); 
		 
		 
		int kids = Integer.parseInt(one);
		int nt = Integer.parseInt(two);;
		int sk = Integer.parseInt(three);;

		boolean start = false;
		int FT = -1;
		sk = sk - 1;
		while (nt != 0) {
			for (int i = 0; i < kids; i++) {
				if (!start && sk == i) {
					start = true;
				}
				if (start) {
					nt = nt -1;
					if(nt == 0){
						FT = i+1;
						break;
					}
				}
			}
		}
		
		System.out.println(FT);

	}

}
