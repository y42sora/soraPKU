package volume1;
import java.util.HashMap;
import java.util.Scanner;

public class PKU1008 {
	public static void main(String[] args) {
		PKU1008 m = new PKU1008();
		m.start();
	}

	void start() {

		Scanner sc = new Scanner(System.in);

		// 数の読み込み＆出力
		int n = sc.nextInt();
		System.out.println(n);

		// 月と数字の対応表の作成
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String[] m = { "pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin",
				"mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan",
				"pax", "koyab", "cumhu", "uayet" };
		String[] t = { "imix", "ik", "akbal", "kan", "chicchan", "cimi",
				"manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix",
				"mem", "cib", "caban", "eznab", "canac", "ahau" };

		for (int i = 0; i < m.length; i++) {
			hm.put(m[i], i);
		}

		for (int i = 0; i < n; i++) {

			// 歴の読み込み
			String str;
			str = sc.next();
			int day = Integer.parseInt(str.substring(0, str.length() - 1));
			int month = hm.get(sc.next());
			int year = sc.nextInt();

			// 日にちに変換
			int days = changeDay(year, month, day);

			// 答えに変換
			String ans = changeTzolkin(days, t);

			// 出力
			 System.out.println(ans);

		}

	}

	private String changeTzolkin(int days, String[] t) {
		// Tozlikin歴に変換する

		int year = days / 260;
		days = days % 260;
		int month = days % 20;
		int day = days % 13 + 1;

		return (String.valueOf(day) + " " + t[month] + " " + String
				.valueOf(year));
	}

	private int changeDay(int year, int month, int day) {
		int days = 0;

		// 年計算
		days += year * 365;

		// 月の変換、特に何も考える必要はない
		days += month * 20;

		// 日の変換、そのまま
		days += day;

		return days;
	}
}
