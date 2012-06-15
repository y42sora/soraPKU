/*
 * http://acm.pku.edu.cn/JudgeOnline/problem?id=2683
 * PKU2683
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PKU2683 {
	public static void main(String args[]) throws IOException{
		PKU2683 m = new PKU2683();
		m.main();
	}

	void main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		String[] s;
		str = br.readLine();
		
		int data = Integer.parseInt(str);
		
		for(int i=0; i<data; i++){
			int max = -1;
			
			str = br.readLine();
			int gold = Integer.parseInt(str);
			str = br.readLine();
			int year = Integer.parseInt(str);
			str = br.readLine();
			int n = Integer.parseInt(str);
			
			for(int j=0; j<n; j++){
				str = br.readLine();
				s = str.split(" ");
				int flag = Integer.parseInt(s[0]);
				double rate = Double.parseDouble(s[1]);
				double charge = Double.parseDouble(s[2]);
				int now;
				if(flag == 0){
					//single
					now = single(gold,rate,charge,year);
				}else{
					//compound
					now = compound(gold,rate,charge,year);
				}
				
				if(now > max)max = now;
			}
			System.out.println(max);
		}
		

	}
	
	int single(int gold,double rate,double charge,int year){
		int ac = 0;
		for(int i=0; i< year; i++){
			ac += gold*rate;
			gold -= charge;
		}
		return gold+ac;
	}
	
	int compound(int gold,double rate,double charge,int year){
		
		for(int i=0; i<year;i++){
			gold += gold*rate;
			gold -= charge;
		}
		return gold;

	}

}
