import java.util.ArrayList;
import java.util.Scanner;

public class PKU3000 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PKU3000 m = new PKU3000();
		m.start();
	}

	private void start() {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			
			int round = sc.nextInt();
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			boolean map[][] = new boolean[x+2][y];
			boolean[][][] bigmap = new boolean[y][x+2][y];
			boolean[][][] points = new boolean[y][x+2][y];

			
			Point start = null;
			Point end = null;

			
			
			for(int j = 0; j < x+2; j++){
				String str = sc.next();
				for(int k = 0; k < y; k++){
					if(str.charAt(k) == 'X'){
						map[j][k] = false;
					}else if(str.charAt(k) == 'O'){
						map[j][k] = true;
					}else if(str.charAt(k) == 'G'){
						map[j][k] = true;
						end = new Point(j,k);
					}else if(str.charAt(k) == 'F'){
						map[j][k] = true;
						start = new Point(j,k);
					}
				}
			}

			bigmap = makebigmap(map,x,y);
			int ans = solv(start,end,bigmap,round,x,y,points);
			
			if(ans == -1){
				System.out.println("The problem has no solution.");
			}else{
				System.out.println("The minimum number of turns is " + ans + ".");
			}
		}

		
	}

	
	public int solv(Point start, Point end, boolean[][][] map,int round,int x,int y, boolean[][][] points) {
		
		
		ArrayList<State> ar = new ArrayList<State>();

		//make first state
		putAr(ar,start,map,0,x,y,points);
		
		//State s = new State(start.x,start.y,0);
		//ar.add(s);

		return solvD(0,end,round,ar,x,y,map,points);
	}



	public void putAr(ArrayList<State> ar, Point now, boolean[][][] map, int time, int x, int y, boolean[][][] points) {
		
		int newx,newy;
		
		int nowtime = time+1;
		
		time = (time+1) % y;
		
		int n = 0;
		/*
		newx = now.x -1;
		newy = now.y -1;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				State s = new State(newx,newy,nowtime);
				ar.add(s);
			}
		}
		*/
		
		newx = now.x -1;
		newy = now.y;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				if(!points[time][newx][newy]){
					points[time][newx][newy] = true;
					State s = new State(newx,newy,nowtime);
					ar.add(s);
					n++;
				}
			}
		}
		
		newx = now.x;
		newy = now.y -1;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				if(!points[time][newx][newy]){
					points[time][newx][newy] = true;
					State s = new State(newx,newy,nowtime);
					ar.add(s);
					n++;
				}
			}
		}

		newx = now.x;
		newy = now.y;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				if(!points[time][newx][newy]){
					points[time][newx][newy] = true;
					State s = new State(newx,newy,nowtime);
					ar.add(s);
					n++;
				}
			}
		}
		
		newx = now.x+1;
		newy = now.y;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				if(!points[time][newx][newy]){
					points[time][newx][newy] = true;
					State s = new State(newx,newy,nowtime);
					ar.add(s);
					n++;
				}
			}
		}

		newx = now.x;
		newy = now.y+1;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				if(!points[time][newx][newy]){
					points[time][newx][newy] = true;
					State s = new State(newx,newy,nowtime);
					ar.add(s);
					n++;
				}
			}
		}
		
		/*
		newx = now.x +1;
		newy = now.y +1;
		if(isOk(newx,newy,x,y)){
			if(map[time][newx][newy]){
				State s = new State(newx,newy,nowtime);
				ar.add(s);
			}
		}
		*/
	}

	public boolean isOk(int newx, int newy, int x, int y) {
		
		if(0 <= newx && newx < x+2)
			if(0 <= newy && newy < y)
				return true;
		
		return false;
	}

	public int solvD(int now,Point end, int round,ArrayList<State> ar,int x,int y,boolean map[][][],boolean[][][] points) {
		
		ArrayList<State> newar = new ArrayList<State>();
	
		if(ar.size() == 0) return -1;
		if(round < now) return -1;
		
		for(State s : ar){
			if(s.now.isE(end)) return s.t;
			
			putAr(newar,s.now,map,s.t,x,y,points);
		}
		
		return solvD(now+1,end,round,newar,x,y,map,points);
	}

	public boolean[][][] makebigmap(boolean[][] map,int x,int y) {
		boolean bigmap[][][] = new boolean[y][x+2][y];
		
		boolean right = true;
		
		for(int i=0; i<x+2; i++){
			for(int j=0; j<y; j++){
				bigmap[0][i][j] = map[i][j];
			}
		}
		
		
		
		for(int i=1; i<y; i++){
			//round
			
			for(int j=x; 0<j; j--){
				//line

				if(right){
					for(int k=1; k<y; k++){
						bigmap[i][j][k] = bigmap[i-1][j][k-1];
					}
					bigmap[i][j][0] = bigmap[i-1][j][y-1];
				}else{
					for(int k=0; k<y-1; k++){
						bigmap[i][j][k] = bigmap[i-1][j][k+1];
					}
					bigmap[i][j][y-1] = bigmap[i-1][j][0];
				}
				
				for(int k=0; k<y; k++){
					bigmap[i][0][k] = true;
					bigmap[i][x+1][k] = true;
				}
				
				right = !right;
			}
		}
		return bigmap;
	}

	
}

class State{
	Point now;
	int t;
	
	State(int x,int y,int t){
		now = new Point(x,y);
		this.t = t;
	}
	
	public boolean isE(State s){
		if(s.now.isE(now))
			if(t == s.t)
				return true;
		
		return false;
	}
}
class Point{
	int x,y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean isE(Point p){
		if(this.x == p.x && this.y == p.y)return true;
		return false;
	}
}
