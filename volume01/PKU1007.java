package volume1;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class PKU1007 {
	public static void main(String[] args) {
		PKU1007 m = new PKU1007();
		m.start();
	}

	void start() {
		/*
		 * バブルソートして、入れ替えた回数を数えれば良さそう
		 */
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int l = sc.nextInt();
		list[] ans = new list[l];

		hs.put("A", 1);
		hs.put("C", 2);
		hs.put("G", 3);
		hs.put("T", 4);

		for (int k = 0; k < l; k++) {
			// 文字列読み込み
			String str = sc.next();

			// 文字列分割
			int length = Sort(str.split(""));

			// リストに追加
			ans[k] = new list(str, length);
		}
		Arrays.sort(ans);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i].str);
		}
	}

	Hashtable<String, Integer> hs = new Hashtable<String, Integer>();

	int Sort(String[] str) {
		int num = 0;
		// 最後の要素を除いて、すべての要素を並べ替えます
		for (int i = 1; i < str.length - 1; i++) {
			// 下から上に順番に比較します
			for (int j = str.length - 1; j > i; j--) {
				if (hs.get(str[j]) < hs.get(str[j - 1])) {
					String t = str[j];
					str[j] = str[j - 1];
					str[j - 1] = t;
					num++;
				}
			}
		}
		return num;
	}

}

class list implements Comparable<Object> {
	String str;
	int length;

	list(String str, int length) {
		this.str = str;
		this.length = length;
	}

	@Override
	public int compareTo(Object o) {
		list l = (list) o;
		return this.length - l.length;
	}
}
