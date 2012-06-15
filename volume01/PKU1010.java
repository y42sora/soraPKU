package volume1;
import java.util.ArrayList;
import java.util.Scanner;

public class PKU1010 {
	public static void main(String[] args) {
		PKU1010 m = new PKU1010();
		m.start();
	}

	void start() {
		Scanner sc = new Scanner(System.in);

		// バックトラックでそう当たりかな.

		ArrayList<Integer> ar;
		int get;

		while (sc.hasNext()) {
			ar = new ArrayList<Integer>();
			while ((get = sc.nextInt()) != 0) {
				ar.add(Integer.valueOf(get));
			}

			int stamp[] = new int[ar.size()];
			for (int i = 0; i < stamp.length; i++) {
				stamp[i] = ar.get(i);
			}

			ar = new ArrayList<Integer>();
			while ((get = sc.nextInt()) != 0) {
				ar.add(Integer.valueOf(get));
			}

			int customers[] = new int[ar.size()];
			for (int i = 0; i < customers.length; i++) {
				customers[i] = ar.get(i);
			}

			solve(stamp, customers);
		}
	}

	void solve(int[] stamp, int[] customers) {

		Ans ans = null;

		for (int i = 0; i < customers.length; i++) {
			ans = new Ans();
			int temp[] = new int[4];
			int bu[] = new int[4];
			go(0, 0, 0, 0, customers[i], stamp,temp,bu,ans);
			if(ans.max == -1)
				System.out.println(customers[i] + "  ---- none");
			else if(ans.tie)
				System.out.println(customers[i] + " (" + ans.s + "): tie");
			else{
				System.out.print(customers[i] + " (" + ans.s + "):");
				for (int j = 0; j < ans.num; j++) {
					System.out.print(" " + ans.ans[j]);
					
				}
				System.out.println("");
			}
		}
		
		
		

	}

	/*
	 * iが今配列のどこまで見ているか 
	 * nowが現在値。 
	 * numが今とっている個数、4個まで。
	 * sが選んだ種類
	 * customersが求めるスコア
	 * tempが現在の回答 
	 * stampが要素が入っている配列
	 * buがどれを答えに入れたかを覚えておく配列
	 */

	private void go(int i, int now, int num,int s, int customers, int[] stamp,int[] temp,int[] bu, Ans ans) {
		if(now >= customers || num == 4 || i == stamp.length){
			//求める総額を取ったか、四個取った
			if(now == customers){
				//求める総額を取った
				ans.reg(temp, num, s);
			}
			return;
		}
		
		//取る
		boolean flag = false;
		for (int j = 0; j < num; j++) {
				if(i == bu[j]){
					//既に登録済みかどうか
					flag = true;
					continue;
				}
		}
		temp[num] = stamp[i];
		bu[num] = i;
		if(flag)
			go(i,now + stamp[i], num+1, s, customers, stamp, temp,bu,ans);
		else
			go(i,now + stamp[i], num+1, s+1, customers, stamp, temp,bu,ans);
		
		//取らない
		go(i+1,now, num, s, customers, stamp, temp, bu, ans);
		
		return;
	}

	class Ans {
		// 答えの保存
		int ans[];
		// 答えの個数
		int num;
		// 同じものが二つ以上あったか
		boolean tie;
		//選んだ種類数
		int s;
		//最大値
		int max;

		Ans() {
			ans = new int[4];
			num = 0;
			tie = false;
			s = 0;
			max = -1;
		}
		
		public void reg(int[] ans,int num,int s){
			if(s > this.s)	copy(ans,num,s);
			else if(s == this.s){
				
				//同じ場合は合計数が少ない方
				if(num < this.num) copy(ans,num,s);
				else if(num == this.num){
					
					//また同じ場合は最大値が一番大きいもの
					int temp = 0;
					for (int i = 0; i < ans.length; i++) {
						temp = Math.max(temp, ans[i]);
					}
					
					if(temp > max) copy(ans,num,s);
					if(temp == max) tie = true;
				}
				
			}
			
			
		}

		private void copy(int[] ans, int num, int s) {
			this.ans = ans.clone();
			this.num = num;
			this.s = s;
			tie = false;
			
			max = ans[0];
			for (int i = 1; i < ans.length; i++) {
				int j = ans[i];
				if(j > max) max = j;
			}
		}
	}
}
