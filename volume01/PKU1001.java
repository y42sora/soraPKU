package volume1;


import java.math.*;
import java.util.*;


public class PKU1001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			while(str.charAt(str.length()-1) == '0'){
				str = str.substring(0,str.length()-1);
			}	
			BigDecimal a = new BigDecimal(str);
			int b = sc.nextInt();
						
			BigDecimal x = new BigDecimal("1");	
			for(int i=0; i<b; i++){
				x = x.multiply(a);
			}
			String st = x.toPlainString();		
			if(st.startsWith("0.")){
				st = st.substring(1);
			}
			System.out.println(st);
		}
	}
}
