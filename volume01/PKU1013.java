package volume1;
import java.util.Scanner;

/*
 * 

Sample input 
12 
ABCD EFGH even 
ABCI EFJK up 
ABIJ EFGH even 
AGHL BDEC even 
JKI ADE up 
J K even 
ABCDEF GHIJKL up 
ABC DEF even 
I J down 
ABCDEF GHIJKL up 
ABHLEF GDIJKC down 
CD HA even 
A B up 
B A down 
A C even 
A B up 
B C even 
DEFG HIJL even 
ABC DEJ down 
ACH IEF down 
AHK IDJ down 
ABCD EFGH even 
AB IJ even 
A L down 
EFA BGH down 
EFC GHD even 
BA EF down 
A B up 
A C up 
L K even 
ACEGIK BDFHJL up 
ACEGIL BDFHJK down 
ACEGLK BDFHJI down 
ACEGIK BDFHJL up 
ACEGIL BDFHJK down 
ACEGLK BDFHJI up 

Sample output 
K is the counterfeit coin and it is light. 
I is the counterfeit coin and it is heavy. 
I is the counterfeit coin and it is light. 
L is the counterfeit coin and it is light. 
B is the counterfeit coin and it is light. 
A is the counterfeit coin and it is heavy. 
A is the counterfeit coin and it is light. 
L is the counterfeit coin and it is heavy. 
A is the counterfeit coin and it is light. 
A is the counterfeit coin and it is heavy. 
L is the counterfeit coin and it is light. 
K is the counterfeit coin and it is heavy.

from http://blog.csdn.net/ChinaCzy/archive/2010/01/02/5119405.aspx
 */

public class PKU1013 {
	public static void main(String[] args) {
		PKU1013 m = new PKU1013();
		m.start();
	}
	
	void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			String s[] = new String[3];
			s[0] = sc.next() + " " + sc.next() + " " + sc.next();
			s[1] = sc.next() + " " + sc.next() + " " + sc.next();
			s[2] = sc.next() + " " + sc.next() + " " + sc.next();
			System.out.println(solv(s));
		}
	}
	
	public String solv(String[] s) {
		/*
		 * 12枚のコインそれぞれについて重い、軽いと仮定する
		 * 矛盾がなければそれが答え
		 */
		
		
		/*
		 * 重い場合は1
		 * 軽い場合は-1
		 * 普通の場合は0
		 */
		int flag[] = new int[12];
		
		for(int i=0; i<12; i++){
			
			// 重くしてみる
			flag[i] = 1;
			if(compall(s,flag))	break;
			
			// 軽くしてみる
			flag[i] = -1;
			if(compall(s,flag))	break;
			
			flag[i] = 0;
		}
		

		return makeAnser(flag);
	}

	private String makeAnser(int[] flag) {
		for (int i = 0; i < flag.length; i++) {
			if(flag[i] != 0){
				char c = (char) ('A' + i);
				
				if(flag[i] == 1){
					//軽い
					String str = " is the counterfeit coin and it is light.";
					return String.valueOf(c) + str;
				}else{
					//重い
					String str = " is the counterfeit coin and it is heavy.";
					return String.valueOf(c) + str;
				}
				
			}
			
		}

		return null;
	}

	private boolean compall(String[] s, int[] flag) {
		/*
		 * compを使って条件と矛盾してないかを判断する
		 */

		for(int i=0; i<s.length; i++){
			String[] str = s[i].split(" ");
			
			//条件と矛盾する
			if(!comp(str[0],str[1],flag).equals(str[2])) return false;
		}
		
		return true;
	}

	private String comp(String left,String right, int[] flag) {
		/*
		 * 与えられた2つの重さを量り、結果を返す
		 */
		
		int l = 0;
		int r = 0;
		
		for (int i = 0; i < left.length(); i++) {
			char c = left.charAt(i);
			l += flag[c-'A'];
		}
		
		for (int i = 0; i < right.length(); i++) {
			char c = right.charAt(i);
			r += flag[c-'A'];
		}
		
		if(l < r) return "up";
		if(l > r) return "down";
		return "even";

		
	}

}
