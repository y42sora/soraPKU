/*
 * http://acm.pku.edu.cn/JudgeOnline/problem?id=1978
 * pku1978
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PKU1978 {
	public static void main(String args[]) {
		PKU1978 m = new PKU1978();
		try {
			m.main();
		} catch (IOException e) {
			// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
			e.printStackTrace();
		}
	}

	void main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		
		
		
		while(true){
			str = br.readLine();
			String [] s = str.split(" ");
			
			int n = Integer.parseInt(s[0]);
			int r = Integer.parseInt(s[1]);
			if(n == 0 && r == 0)break;
			
			int deck[] = new int[n];
			int j = 1;
			for(int i=n-1; i >= 0; i--){
				deck[i] = j++;
			}
			
			for(int i=0; i<r; i++){
				int ndeck[] = new int[n];
				str = br.readLine();
				s = str.split(" ");
				int p = Integer.parseInt(s[0]);
				int c = Integer.parseInt(s[1]);
				
				j=0;
				
				for(int k=0; k<c;k++){
					ndeck[j++] = deck[p-1+k];
				}
				for(int k=0; k<p-1; k++){
					ndeck[j++] = deck[k];
				}
				for(int k=c+p-1; k<n; k++){
					ndeck[j++] = deck[k];
				}
				deck = ndeck;
				
			}
			System.out.println(deck[0]);
		}
		
	}

}
