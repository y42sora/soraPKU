import java.util.Scanner;


public class PKU2685 {

	public static void main(String[] args) {

		PKU2685 p = new PKU2685();
		p.main();

	}

	private void main() {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			int x = getMCXI(sc.next());
			int y = getMCXI(sc.next());
			String str = makeMCXI(x+y);
			System.out.println(str);;
		}
	}



	String makeMCXI(int num){
		int i = num % 10;
		num = num / 10;

		int x = num % 10;
		num = num / 10;

		int c = num % 10;
		num = num / 10;

		int m = num % 10;
		num = num / 10;

		String str = "";

		if(m != 0){
			if(1 < m)
				str += String.valueOf(m);
			str += "m";
		}

		if(c != 0){
			if(1 < c)
				str += String.valueOf(c);
			str += "c";
		}

		if(x != 0){
			if(1 < x)
				str += String.valueOf(x);
			str += "x";
		}

		if(i != 0){
			if(1 < i)
				str += String.valueOf(i);
			str += "i";
		}

		return str;
	}

	int getMCXI(String str){
		int num = 0;

		num += getNum(str,'m') * 1000;
		num += getNum(str,'c') * 100;
		num += getNum(str,'x') * 10;
		num += getNum(str,'i');

		return num;
	}

	int getNum(String str, char c){
		int i;

		char n = 'm';

		for(i=0;i <str.length(); i++){
			if(str.charAt(i) == c)break;
			n = str.charAt(i);
		}

		if(i == str.length()) return 0;

		if(n == 'm' || n == 'c' || n == 'x' || n == 'i' )return 1;

		return n - '0';
	}

}
