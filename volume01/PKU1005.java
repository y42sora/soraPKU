package volume1;

import java.util.Scanner;

public class PKU1005 {

	public static void main(String[] args) {
		PKU1005 m = new PKU1005();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			double r = Math.sqrt(x*x + y*y);
			
			int year = (int)(Math.ceil(Math.PI * r * r / 50.0 / 2));
			
			System.out.println("Property " + (i+1) + ": This property will begin eroding in year " + year + ".");
		}
		System.out.println("END OF OUTPUT.");
	}

}
