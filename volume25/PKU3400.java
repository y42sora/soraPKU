import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PKU3400 {

	public static void main(String[] args) {
		PKU3400 m = new PKU3400();
		try {
			m.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void start() throws IOException {
		
		InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader bre = new BufferedReader(inp);
        
        String str = bre.readLine();
        
        String s[] = str.split(" ");
		
		int n = Integer.parseInt(s[0]);
		int d = Integer.parseInt(s[1]);

		int[][] stone = new int[n][2];
		
		for(int i=0; i<n; i++){
			str = bre.readLine();
			s = str.split(" ");
			stone[i][0] = Integer.parseInt(s[0]);
			stone[i][1] = Integer.parseInt(s[1]);
		}
		
		
		int ans = solv(d,stone);
		
		System.out.println(ans);
	}

	 int solv(int d, int[][] stone) {
		max = -1;
		used = new boolean[stone.length];
		now = new int[stone.length];
		
		int all = 0;
		for(int i=0; i<stone.length; i++){
			all += stone[i][1];
		}

		back(0,stone,d,0,0,true,0,all);
		return max;
	}
	

	boolean[] used;
	int[] now;
	int max;
	
	
	void back(int i,int[][] stone,int d,int wA,int wB,boolean sw,int now,int all){
		
		//now: nowcost
		
		if(i == stone.length){
			
			// hikaku
			if(now > max){
				max = now;
			}
			return;
		}
		
		if(max > now + all)return;
		
		for(int j=0; j<stone.length; j++){
			if(!used[j]){
				used[j] = true;
				
				if(sw){
					int noww = wA + stone[j][0];
					
					boolean nowsw = true;
					if(noww-wB > d)nowsw = false;
					
					back(i+1,stone,d,noww,wB,nowsw,now,all-stone[j][1]);
				}else{
					int noww = wB + stone[j][0];
					
					boolean nowsw = false;
					if(noww - wA > d)nowsw = true;
					
					back(i+1,stone,d,wA,noww,nowsw,now + stone[j][1],all - stone[j][1]);
					
				}
				
				used[j] = false;
			}
		}
	}
}
