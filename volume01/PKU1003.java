package volume1;

import java.util.Scanner;

public class PKU1003 {

	public static void main(String[] args) {
		PKU1003 m = new PKU1003();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		while(true){
			double len = sc.nextDouble();
			int ans = 1;
			double now = 0.0;
			
			if(len == 0.00) break;
			
			while(now < len){
				now = now +  1.0 / ((double)(ans++) + 1.0);
			}
			System.out.println(ans-1 + " card(s)");
		}
	}

}
