package volume1;

import java.util.Scanner;


public class PKU1002 {
	
	public static String rep(String str){
		String s = "";
		for(int i=0; i<str.length(); i++){
			switch(str.charAt(i)){
			case 'A':
			case 'B':
			case 'C': s = s + "2";
			break;

			case 'D':
			case 'E':
			case 'F': s = s + "3";
			break;

			case 'G':
			case 'H':
			case 'I': s = s + "4";
			break;

			case 'J':
			case 'K':
			case 'L': s = s + "5";
			break;
			
			case 'M':
			case 'N':
			case 'O': s = s + "6";
			break;

			case 'P':
			case 'R':
			case 'S': s = s + "7";
			break;
			
			case 'T':
			case 'U':
			case 'V': s = s + "8";
			break;
			
			case 'W':
			case 'X':
			case 'Y': s = s + "9";
			break;
			
			case '-':
				break;
			
			default:
				s = s + str.charAt(i);
			}
		}
		
		
		return s;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String ar[] = new String[num];
		
		for(int i=0; i<num; i++){
			String str = sc.next();
			ar[i] = rep(str);
			//ar[i] = str.replaceAll("-", "").replaceAll("[ABC]", "2").replaceAll("[DEF]", "3").replaceAll("[GHI]", "4").replaceAll("[JKL]", "5").replaceAll("[MNO]", "6").replaceAll("[PRS]", "7").replaceAll("[TUV]", "8").replaceAll("[WXY]", "9");
		}
		java.util.Arrays.sort(ar);
		
		String b = ar[0];
		int n = 1;
		boolean flag = false;
		for(int i=1; i<num; i++){
			if(b.equals(ar[i])){
				n++;
				continue;
			}
			if(n == 1){
				b = ar[i];
				continue;
			}
			flag = true;
			String s = b;
			System.out.println(s.substring(0,3) + "-" + s.substring(3) + " " + n);
			n = 1;
			b = ar[i];
		}
		
		if(n != 1){
			flag = true;
			String s = b;
			System.out.println(s.substring(0,3) + "-" + s.substring(3) + " " + n);
		}

		if(!flag){
			System.out.println("No duplicates.");
		}
		
	}

}
