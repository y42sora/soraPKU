package volume1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PKU1004 {

	public static void main(String[] args) {
		PKU1004 m = new PKU1004();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		double sum = 0.0;
		for(int i=0; i<12; i++){
			sum += sc.nextDouble();
		}
		DecimalFormat form = new DecimalFormat("#############.##");
		System.out.println("$" + form.format(sum/12.0));
	}

}
