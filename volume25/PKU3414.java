import java.util.ArrayList;
import java.util.Scanner;


public class PKU3414 {

	public static void main(String[] args) {
		PKU3414 m = new PKU3414();
		m.start();


	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		bar ans = solv(a,b,c);
		
		if(ans == null){
			System.out.println("impossible");
			return;
		}
		
		System.out.println(ans.t.count);
		
		ArrayList<String> anstr = new ArrayList<String>();
		String str;
		while(ans.before != null){
			te sec = ans.t;
			switch(sec.flag){
			case 1:
				str = ("FILL(" + sec.i + ")");
				anstr.add(str);
				break;
			case 2:
				str = ("DROP(" + sec.i + ")");
				anstr.add(str);
				break;
			case 3:
				str = ("POUR(" + sec.i + "," + sec.j + ")");
				anstr.add(str);
				break;
			}
			ans = ans.before;
		}
		
		for(int i=anstr.size()-1; 0 <= i; i--){
			System.out.println(anstr.get(i));
		}
		
	}
	
	int sizea;
	int sizeb;
	int ansc;
	boolean all[][];

	private bar solv(int a, int b, int c) {
		sizea = a;
		sizeb = b;
		ansc = c;
		
		all = new boolean[101][101];

		ArrayList<bar> ar = new ArrayList<bar>();
		
		ar.add(new bar(null,null,0,0));
		
		return dike(ar,0);


		
	}
	
	public bar dike(ArrayList<bar> ar, int count){
		ArrayList<bar> newar = new ArrayList<bar>();
		if(ar.size() == 0) return null;
		for (bar b : ar) {
			if(b.a == ansc || b.b == ansc) return b;

			
			bar newb;
			newb = FILL(true,b,count+1);
			if(!all[newb.a][newb.b]){
				all[newb.a][newb.b] = true;
				newar.add(newb);
			}

			newb = FILL(false,b,count+1);
			if(!all[newb.a][newb.b]){
				all[newb.a][newb.b] = true;
				newar.add(newb);
			}
			
			newb = DROP(true,b,count+1);
			if(!all[newb.a][newb.b]){
				all[newb.a][newb.b] = true;
				newar.add(newb);
			}
			
			newb = DROP(false,b,count+1);
			if(!all[newb.a][newb.b]){
				all[newb.a][newb.b] = true;
				newar.add(newb);
			}
			
			newb = POUR(true,b,count+1);
			if(!all[newb.a][newb.b]){
				all[newb.a][newb.b] = true;
				newar.add(newb);
			}
			
			newb = POUR(false,b,count+1);
			if(!all[newb.a][newb.b]){
				all[newb.a][newb.b] = true;
				newar.add(newb);
			}
			
		}
		
		return dike(newar,count+1);
		
	}
	
	public bar POUR(boolean a,bar b,int newc){
		te t;
		bar ret;
		if(a){
			t = new te(3,1,2,newc);
			
			int newa = Math.max(b.a+b.b-sizeb,0);
			int newb = Math.min(b.a+b.b, sizeb);
			ret = new bar(b,t,newa,newb);
		}else{
			t = new te(3,2,1,newc);
			int newa = Math.min(b.a+b.b, sizea);
			int newb = Math.max(b.a+b.b-sizea,0); 
			ret = new bar(b,t,newa,newb);
		}
		
		return ret;
	}
	
	public bar DROP(boolean a,bar b,int newc){
		te t;
		bar ret;
		if(a){
			t = new te(2,1,2,newc);
			ret = new bar(b,t,0,b.b);
		}else{
			t = new te(2,2,1,newc);
			ret = new bar(b,t,b.a,0);
		}
		
		return ret;
	}
	
	public bar FILL(boolean a,bar b,int newc){
		
		te t;
		bar ret;
		if(a){
			t = new te(1,1,2,newc);
			ret = new bar(b,t,sizea,b.b);
		}else{
			t = new te(1,2,1,newc);
			ret = new bar(b,t,b.a,sizeb);
		}
		
		return ret;
	}

}

class bar{
	bar before;
	int a,b;
	te t;
	
	public bar(bar before,te t,int a,int b){
		this.before = before;
		this.t = t;
		this.a = a;
		this.b = b;
	}
	
}


class te{
	int flag;
	int i,j;
	int count;
	
	
	public te(int flag,int i,int j,int count){
		this.flag = flag;
		this.i = i;
		this.j = j;
		this.count = count;

	}
}
