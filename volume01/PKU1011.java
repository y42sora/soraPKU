package volume1;
import java.util.Scanner;

public class PKU1011 {
	public static void main(String[] args) {
		PKU1011 m = new PKU1011();
		m.start();
	}
	
	
	
	void start() {
		Scanner sc = new Scanner(System.in);

		// バックトラックで総当たりかな.
		// 枝刈りをしまくれば早くなるはず。
		// 現在の長さを求め、残りの棒をどう足してもその長さが作れないなら終了。

		while(true){
			int n = sc.nextInt();
			if(n == 0)break;
			
			sum = 0;
			br = new int[51];
			
			max = -1;

			for (int i = 0; i < n; i++) {
				int temp = sc.nextInt();
				sum += temp;
				br[temp]++;
				if(temp > max) max = temp;
			}
			
			//最大値を取り出す
			length = max+1;
			
			//合計値の約数の内、最大値以上の物について調べる。
			while(true){
				if(sum % length == 0){
					if(solv(0,0)){
						System.out.println(length);
						break;
					}
				}
				length++;
			}
		}
	}

	int br[];
	int sum;
	int length;
	int max;

	private boolean solv(int now,int plen) {
		if(now == sum) return true;
		if(now % length == 0) plen = max;
		
		for (; plen >= 0; plen--) {
			if(br[plen] != 0){
				//使われていない
				int next = now + plen;
				if(now / length == (next-1)/length){
					//今回の合計が長さ以上にならない。
					
					br[plen]--;
					if(solv(next,plen)){
						return true;
					}
					br[plen]++;
					if(now%length == 0) return false;
				}
			}
		}
		return false;
	}
	
}
