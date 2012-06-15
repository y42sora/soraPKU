/*
 * PKU2200
 * http://acm.pku.edu.cn/JudgeOnline/problem?id=2200
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PKU2200 {

	public static void main(String[] args) {
		PKU2200 m = new PKU2200();
		m.start();

	}

	private void start() {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i=0; i<n; i++){

			String str = sc.next();
			for(int j=1; j<cardnum; j++){
				str = str + " " + sc.next();
			}

			String ans = solv(str);

			System.out.println("Problem " + (i+1) + ": " + ans);
		}
	}

	public static final int cardnum = 5;;

	public String solv(String str){

		Tranp t[] = makeTranp(str);

		Arrays.sort(t,new TranpOrd());

		int[] ans = null;

		for(int i=0; i<t.length; i++){
			for(int j=i; j<t.length; j++){
				if(i==j)continue;
				if(t[i].suit != t[j].suit) continue;

				int[] temp = getAns(i,j,t);
				if(ans == null){
					ans = temp;
				}if(comp(temp,ans,t) < 0){
					ans = temp;
				}
			}
		}

		String s = "";

		for(int k=0; k<cardnum-1; k++){
			s = s +  t[ans[k]].toString() + " ";
		}

		s = s + t[ans[cardnum-1]].toString();


		return s;
	}

	private int comp(int[] a,int[] b,Tranp[] t){
		for(int i=0; i<cardnum; i++){
			int c = t[a[i]].compareTo(t[b[i]]);
			if(c != 0){
				return c;
			}
		}
		return 0;
	}


	private Tranp[] makeTranp(String str) {
		String[] s = str.split(" ");

		Tranp t[] = new Tranp[cardnum];

		for(int i=0; i<s.length; i++){
			String su = s[i].substring(s[i].length()-1,s[i].length());
			String value = s[i].substring(0,s[i].length()-1);

			int suit = 0;
			if(su.equals("C")){
				suit = 1;
			}else if(su.equals("D")){
				suit = 2;
			}else if(su.equals("H")){
				suit = 3;
			}else{
				suit = 4;
			}

			if(value.equals("A")){
				value = "1";
			}else if(value.equals("J")){
				value = "11";
			}else if(value.equals("Q")){
				value = "12";
			}else if(value.equals("K")){
				value = "13";
			}

			t[i] = new Tranp(Integer.valueOf(value),suit);
		}

		return t;
	}

	private int[] getAns(int i, int j, Tranp[] t) {

		int num[] = new int[cardnum];

		for(int k=0; k<cardnum; k++){
			num[k] = -1;
		}

		int x = 0;

		int temp =t[j].compareTo(t[i]);

		if(temp < 7 && 0 < t[j].compareTo(t[i])){

			num[1] = i;
			num[0] = j;

			x = t[num[0]].compareTo(t[num[1]]);

		}else{

			num[0] = i;
			num[1] = j;

			x = t[num[0]].value + 13  - t[num[1]].value;

		}

		int small = 0;
		for(int k=0; k<cardnum; k++){
			if(k == i)continue;
			if(k == j)continue;
			small = k;
			break;
		}

		int before = -1;
		int after = -1;;

		if(x > 3){
			for(int k=0; k<cardnum; k++){
				if(k == j)continue;
				if(k == i)continue;
				if(k == small)continue;

				if(after == -1){
					after = k;
				}else{
					before = k;
				}
			}
			x = x - 3;
		}else{
			for(int k=0; k<cardnum; k++){
				if(k == j)continue;
				if(k == i)continue;
				if(k == small)continue;

				if(before == -1){
					before = k;
				}else{
					after = k;
				}
			}
		}

		num[x+1] = small;

		for(int k=0; k<cardnum; k++){
			if(num[k] == -1){
				/*
				if(k == j)continue;
				if(k == i)continue;
				if(k == small)continue;
				*/

				if(before != -1){
					num[k] = before;
					before = -1;
				}else{
					num[k] = after;
				}
			}
		}


		/*
		 *
		String ans = "";

		for(int k=0; k<cardnum-1; k++){
			ans = ans +  t[num[k]].toString() + " ";
		}

		ans = ans + t[num[cardnum-1]].toString();

		*/


		return num;
	}



	public class TranpOrd implements Comparator<Tranp>{

		@Override
		public int compare(Tranp t0, Tranp t1) {
			return t0.compareTo(t1);
		}

	}

	public class Tranp implements Comparable<Tranp>{
		int value;

		/*
		 * 1 c
		 * 2 d
		 * 3 h
		 * 4 s
		 */
		int suit;


		Tranp(int v,int s){
			value = v;
			suit = s;
		}


		@Override
		public int compareTo(Tranp t) {
			if(value == t.value){
				return suit - t.suit;
			}
			return value - t.value;
		}

		public String toString(){

			String ans = "";

			String str = "";

			switch(value){
			case 1:
				str = "A";
				break;
			case 11:
				str = "J";
				break;
			case 12:
				str = "Q";
				break;
			case 13:
				str = "K";
				break;
			default:
				str = String.valueOf(value);
			}



			switch(suit){
			case 1:
				ans = ans + str + "C";
				break;
			case 2:
				ans = ans + str + "D";
				break;
			case 3:
				ans = ans + str + "H";
				break;
			case 4:
				ans = ans + str + "S";
				break;
			}

			return ans;

		}


	}
}
