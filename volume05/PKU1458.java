import java.util.Scanner;

public class PKU1458 {
	
	public static void main(String[] args) {
		new PKU1458().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			System.out.println(getLCSLength(sc.next(), sc.next()));			
		}
	}
	
	int getLCSLength(String a,String b){
		/*
		 * 最長共通部分列の長さを求める
		 * abcfbcとabfcabを入れると、abfcやabcbの長さ４を返す
		 * 
		 */
		
		int al = a.length();
		int bl = b.length();
		
		int map[][] = new int[al+1][bl+1];
		
		for(int i=1; i<=al; i++)
			for(int j=1; j<=bl; j++)
				if(a.charAt(i-1) == b.charAt(j-1))
					map[i][j] = Math.max(map[i-1][j-1]+1, Math.max(map[i][j-1], map[i-1][j]));
				else
					map[i][j] = Math.max(map[i-1][j-1], Math.max(map[i][j-1], map[i-1][j]));
		
		return map[al][bl];
	}
}
