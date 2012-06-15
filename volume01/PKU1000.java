package volume1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PKU1000 {
	public static void main(String[] args) {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
				String name = br.readLine();
				String s[] = name.split(" ");
				System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
			} catch (IOException e) {
				e.printStackTrace();
			}	}
}
