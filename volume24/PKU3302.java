
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PKU3302 {
	
	public static void main(String[] args) {
		PKU3302 m = new PKU3302();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			String s1 = sc.next();
			String s2 = sc.next();
			
			if(solv(s1,s2)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		
	}

	public boolean solv(String s1, String s2) {
		StringBuffer str = new StringBuffer(s2);
		String s3 = str.reverse().toString();

		
		if(extra(s1,s2) == 1) return true;
		return false;

		//return getAns(s1,s2) || getAns(s1,s3);

		//return solvDP(s1,s2) || solvDP(s1,s3);
	}
	

	private int extra(String s1,String s2){
		int num = 0;
		HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();
		
		input(hm,s1);
		if(!isIn(hm,s2))return num;

		ArrayList<Integer> list = hm.get(s2.charAt(0));
		
		for (Integer integer : list) {
			//�擪�̔ԍ�
			int now = integer.intValue();
			
			num += getEX(1,s2,hm,now);
		}
		
		return num;
	}
	
	

	
	private int getEX(int i, String s2,
			HashMap<Character, ArrayList<Integer>> hm, int now) {
		
		if(i == s2.length() -1) return 1;
		
		int num = 0;
		
		//i�Ԗڂ̕���������ꏊ
		ArrayList<Integer> templist = hm.get(s2.charAt(i));

		//i�Ԗڂ̕����𒲂ׂĂ���
		for(Integer test: templist){
			int nowtemp = test.intValue();
			
			//���������ݒl�����傫���Ƃ���Ō��������ꍇ�͌��ݒl��h��ւ���
			if(now < nowtemp){
				num += getEX(nowtemp,s2,hm,now);
			}
		}
		
		return num;
	}

	// N-gram Index�������@�ɂ���
	private boolean getAns(String s1, String s2){
		
		HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();
		
		input(hm,s1);
		if(!isIn(hm,s2))return false;

		ArrayList<Integer> list = hm.get(s2.charAt(0));
		
		int i = 1;
		for (Integer integer : list) {
			
			//�擪�̔ԍ�
			int now = integer.intValue();
			
			//�Q�Ԗڈȍ~�̕����𒲂ׂ�
			for(i=1; i<s2.length(); i++){
				
				//i�Ԗڂ̕���������ꏊ
				ArrayList<Integer> templist = hm.get(s2.charAt(i));

				//���ݒl���L��
				int before = now;
				
				//i�Ԗڂ̕����𒲂ׂĂ���
				for(Integer test: templist){
					int nowtemp = test.intValue();
					
					//���������ݒl�����傫���Ƃ���Ō��������ꍇ�͌��ݒl��h��ւ���
					if(now < nowtemp){
						now = nowtemp;
						break;
					}
				}
				
				//���ݒl���h��ւ����Ă��Ȃ��Ȃ炻��͂��������Ȃ��ߏI��
				if(before == now) break;
			}
			
			if(i == s2.length()) return true;
		}
		return false;
	}
	
	private boolean isIn(HashMap<Character, ArrayList<Integer>> hm, String s2) {
		//s2�̑S�v�f�����݂��邩�ǂ���
		
		for(int i=0; i<s2.length(); i++){
			if(hm.get(s2.charAt(i)) == null) return false;
		}
		return true;
	}

	private void input(HashMap<Character, ArrayList<Integer>> hm, String s1) {
		
		for(int i=0; i<s1.length(); i++){
			ArrayList<Integer> list = hm.get(s1.charAt(i));
			if(list == null){
				list = new ArrayList<Integer>();
				list.add(i);
				hm.put(s1.charAt(i),list);
				
			}else{
				list.add(i);
			}
		}
	}
	
	
	//���I�v��@�ɂ���
	private boolean solvDP(String s1,String s2){
		if(f(0,0,s1,s2) == s2.length())return true;
		return false;
	}
	
	private int f(int i,int k,String s1,String s2){
		
		if(s1.length() <= i || s2.length() <= k) return k;
		
		if(s1.charAt(i) == s2.charAt(k)){
			return f(i+1,k+1,s1,s2);
		}else{
			return f(i+1,k,s1,s2);
		}
	}
	
	
	
	
	/*
	 * f(i)
	 * Si��p�̒���k��prefix�𕔕���Ƃ��Ď��悤�ȍő��k
	 */
	

}
