package volume1;
import java.util.Scanner;

/*
 * どうせ14個しかないんだし、先に求めちゃえばー？
 * 
   public int solv(int n) {
		
		int ans[] = {0,2,7,5,30,169,441,1872,7632,1740,93313,459901,1358657,2504881};
		return ans[n];

	}
 */

public class PKU1012 {
	public static void main(String[] args) {
		PKU1012 m = new PKU1012();
		m.start();
	}
	
	void start() {
		while(true){
			int n =  get();
			if(n == 0)break;
			System.out.println(solv(n));
		}
	}

	private int get() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	public int solv(int n) {
		
		boolean ar[] = new boolean[n*2];
		
		int i=0;
		
		while(true){
			int now = 0;
			int bad = 0;
			i++;
			
			for (int k = 0; k < ar.length/2; k++) {
				ar[k] = false;
				ar[k+n] = true;
			}
			
			now = (now + i) % ar.length;
			
			if(now == 0)now = ar.length-1;
			else now  = now-1;
			
			//途中で悪人以外を除いた場合
			//既に除いた場所に当たった場合、それは以降同じ事の繰り返しになってしまう
			while(ar[now]){
				bad++;
				ar[ar.length-bad] = false;
				now = (now + i) % (ar.length-bad);
				
				if(now == 0)now = ar.length-bad-1;
				else now  = now-1;
			}
			
			if(bad == n)break;
		}
		
		return i;
	}
	
}
