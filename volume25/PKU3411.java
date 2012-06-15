
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PKU3411 {

	public static void main(String[] args) {
		PKU3411 m = new PKU3411();
			m.start();
	}

	/*
	private void start() throws IOException {
		
		//Scanner sc = new Scanner(System.in);
		 BufferedReader br =
		      new BufferedReader(new InputStreamReader(System.in));


		int n = sc.nextInt();
		int m = sc.nextInt();

		String str = br.readLine();
		
		String[] s = str.split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		s = new String[m];
		
		for(int i=0; i<m; i++){
			//s[i] = sc.next();
			s[i] = br.readLine();
		}
		
		road r[] = makeRoads(s);
		
		int ans = solv(n,r);
		
		System.out.println(ans);
		
	}
	*/
	
	public void start(){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		road r[] = new road[m];
		
		
		for(int i=0; i<m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int p = sc.nextInt();
			int ro = sc.nextInt();
			r[i] = new road(a, b, c, p, ro);
		}
		
		
		
		int ans = solv(n,r);
		
		if(ans == -1){
			System.out.println("impossible");
		}else{
			System.out.println(ans);
		}
		
		
	}
	

	int solv(int n, road[]r) {
		Queue<ver> q = new PriorityQueue<ver>();

		q.add(new ver(1,1,0));
		
		return dike(q,n,r);
	}
	
	
	
	int dike(Queue<ver> q,int n ,road[] r) {
		
		ver v = q.poll();
		if(v == null) return -1;
		
		if(v.now == n) return v.cost;
		if(v.town == 1023) return dike(q,n,r);
		
		for(int i=0; i<r.length; i++){
			if(r[i].a == v.now){
				if(v.isVisit(r[i].c)){
					//c�̏����𖞂����Ă���
					ver newv = new ver(r[i].b, v.town | (1<<r[i].b), v.cost + r[i].p);
					q.add(newv);
				}else{
					ver newv = new ver(r[i].b, v.town | (1<<r[i].b), v.cost + r[i].r);
					q.add(newv);
				}
			}
		}
		
		return dike(q,n,r);
	}
	
	public road[] makeRoads(String[] s){
		road r[] = new road[s.length];
		
		for(int i=0; i<s.length; i++){
			String[] sroad = s[i].split(" ");
			r[i] = new road(Integer.parseInt(sroad[0]),Integer.parseInt(sroad[1]),Integer.parseInt(sroad[2]),Integer.parseInt(sroad[3]),Integer.parseInt(sroad[4])); 
			//r[i] =  new road(Integer.parseInt(sroad[0]),Integer.parseInt(sroad[1]),Integer.parseInt(sroad[2]),Integer.parseInt(sroad[3]),Integer.parseInt(sroad[4]));
		}

		return r;
	}

	/*
	public road[][] makeRoads(String[] s,int n){
		road r[][] = new road[s.length][n];
		
		for(int i=0; i<s.length; i++){
			String[] sroad = s[i].split(" ");
			r[Integer.parseInt(sroad[0])][Integer.parseInt(sroad[1])] = new road(Integer.parseInt(sroad[2]),Integer.parseInt(sroad[3]),Integer.parseInt(sroad[4])); 
			//r[i] =  new road(Integer.parseInt(sroad[0]),Integer.parseInt(sroad[1]),Integer.parseInt(sroad[2]),Integer.parseInt(sroad[3]),Integer.parseInt(sroad[4]));
		}

		return r;
	}
	*/

}



class road{
	int a;
	int b;
	int c;
	int p;
	int r;
	
	public road(int a,int b,int c,int p,int r){
		this.a = a;
		this.b = b;
		this.c = c;
		this.p = p;
		this.r = r;
	}
	
	public boolean isE(road r){
		if(this.a == r.a)
			if(this.b == r.b)
				if(this.c == r.c)
					if(this.p == r.p)
						if(this.r == r.r)
							return true;
		return false;
	}
}

class ver implements Comparable<ver>{
	int town;
	int now;
	int cost;
	
	boolean t[];
	
	public boolean isAll(int x){
		if(town-1 > (1<<(x-1))) return true;
		
		return false;
	}
	
	
	public ver(int now,int town,int cost){
		this.now = now;
		this.town = town;
		this.cost = cost;
		
		t = new boolean[10];
	}

	public boolean isVisit(int x){
		if((this.town & (1 << x)) != 0)
			return true;
		return false;
	}


	@Override
	public int compareTo(ver arg0) {
		return this.cost - arg0.cost;
	}
}
