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

		// ���̓ǂݍ��݁��o��
		int n = sc.nextInt();
		System.out.println(n);

		// ���Ɛ����̑Ή��\�̍쐬
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

			// ���̓ǂݍ���
			String str;
			str = sc.next();
			int day = Integer.parseInt(str.substring(0, str.length() - 1));
			int month = hm.get(sc.next());
			int year = sc.nextInt();

			// ���ɂ��ɕϊ�
			int days = changeDay(year, month, day);

			// �����ɕϊ�
			String ans = changeTzolkin(days, t);

			// �o��
			 System.out.println(ans);

		}

	}

	private String changeTzolkin(int days, String[] t) {
		// Tozlikin���ɕϊ�����

		int year = days / 260;
		days = days % 260;
		int month = days % 20;
		int day = days % 13 + 1;

		return (String.valueOf(day) + " " + t[month] + " " + String
				.valueOf(year));
	}

	private int changeDay(int year, int month, int day) {
		int days = 0;

		// �N�v�Z
		days += year * 365;

		// ���̕ϊ��A���ɉ����l����K�v�͂Ȃ�
		days += month * 20;

		// ���̕ϊ��A���̂܂�
		days += day;

		return days;
	}
}
