package volume1;
import java.util.Scanner;

public class PKU1011 {
	public static void main(String[] args) {
		PKU1011 m = new PKU1011();
		m.start();
	}
	
	
	
	void start() {
		Scanner sc = new Scanner(System.in);

		// �o�b�N�g���b�N�ő������肩��.
		// �}��������܂���Α����Ȃ�͂��B
		// ���݂̒��������߁A�c��̖_���ǂ������Ă����̒��������Ȃ��Ȃ�I���B

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
			
			//�ő�l�����o��
			length = max+1;
			
			//���v�l�̖񐔂̓��A�ő�l�ȏ�̕��ɂ��Ē��ׂ�B
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
				//�g���Ă��Ȃ�
				int next = now + plen;
				if(now / length == (next-1)/length){
					//����̍��v�������ȏ�ɂȂ�Ȃ��B
					
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
