package volume1;
import java.util.Scanner;

public class PKU1009 {
	public static void main(String[] args) {
		PKU1009 m = new PKU1009();
		m.start();
	}

	void start() {

		Scanner sc = new Scanner(System.in);

		while (true) {
			// ���̓ǂݍ���
			int w = sc.nextInt();
			if (w == 0)
				break;

			int now = 0;

			// b�����ݓǂݍ��ݒ�
			// a�����̑O�̓ǂݍ��ݗ�
			int a[] = null;
			int b[] = new int[w + 2];

			int ansa[] = new int[w + 2];
			int ansb[] = new int[w + 2];

			// �l�ƌ�
			int v = -1;
			int n = 0;
			
			System.out.println(w);
			

			while (true) {
				// ���l����
				int x = sc.nextInt();
				// �A�����̓���
				int num = sc.nextInt();
				// ���͏I��
				if (x == 0 && num == 0)
					break;
				for (int i = 0; i < num; i++) {
					// �v�Z���ȒP�ɂ��邽�ߍŏ��ƍŌ������͂���
					if (now == 0)
						b[now++] = x;
					b[now++] = x;

					if (now == w + 1) {
						b[now++] = x;
						if (a != null) {
							// �v�Z����
							for (int j = 1; j < a.length - 1; j++) {
								int max = ansa[j];
								int abs;
								// �����Ƃ̌v�Z
								abs = Math.abs(a[j] - b[j - 1]);
								max = Math.max(max, abs);
								ansb[j - 1] = Math.max(ansb[j - 1], abs);

								// ���Ƃ̌v�Z
								abs = Math.abs(a[j] - b[j]);
								max = Math.max(max, abs);
								ansb[j] = Math.max(ansb[j], abs);

								// �E���Ƃ̌v�Z
								abs = Math.abs(a[j] - b[j + 1]);
								max = Math.max(max, abs);
								ansb[j + 1] = Math.max(ansb[j + 1], abs);

								// �E�Ƃ̌v�Z
								abs = Math.abs(a[j] - a[j + 1]);
								max = Math.max(max, abs);
								ansa[j + 1] = Math.max(ansa[j + 1], abs);
								
								ansa[j] = max;

								if (v == -1)
									v = max;
								if (v == max) {
									n++;
								} else {
									System.out.println(v + " " + n);
									v = max;
									n = 1;
								}
							}
							
							if(v == 0 && n > w && num - i > w * 3){
								//�ȗ��\
								
								//�c��̐�
								int no = num - i;
								
								//�Ō�̎O�s�������̂����ăJ�b�g
								
								int l = no % w;
								int p = no - (l + w*2);
								if(no - w*3 > 0)n += p;
								if(no - w*3 > 0)i += p;
							}
						}
						a = b;
						b = new int[w + 2];
						ansa = ansb;
						ansb = new int[w + 2];
						now = 0;
					}
				}
			}

			b = a;

			for (int j = 1; j < a.length - 1; j++) {
				int max = ansa[j];
				int abs;
				// �����Ƃ̌v�Z
				abs = Math.abs(a[j] - b[j - 1]);
				max = Math.max(max, abs);
				ansb[j - 1] = Math.max(ansb[j - 1], abs);

				// ���Ƃ̌v�Z
				abs = Math.abs(a[j] - b[j]);
				max = Math.max(max, abs);
				ansb[j] = Math.max(ansb[j], abs);

				// �E���Ƃ̌v�Z
				abs = Math.abs(a[j] - b[j + 1]);
				max = Math.max(max, abs);
				ansb[j + 1] = Math.max(ansb[j + 1], abs);

				// �E�Ƃ̌v�Z
				abs = Math.abs(a[j] - a[j + 1]);
				max = Math.max(max, abs);
				ansb[j + 1] = Math.max(ansb[j + 1], abs);

				if (v == -1)
					v = ansa[1];
				else if (v == max) {
					n++;
				} else {
					System.out.println(v + " " + n);
					v = max;
					n = 1;
				}
			}

			System.out.println(v + " " + n);
			System.out.println("0 0");
		}
		System.out.println(0);

	}
}
