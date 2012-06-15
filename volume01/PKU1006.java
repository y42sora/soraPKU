package volume1;

/*
 * C‚È‚çˆêu‚Å‡ŠiBBB
 * 
 * 
 * #include <stdio.h>
 * 
 * int main(void){
 * 	int i,p,e,d,day,j = 1;
 * 	while(1){
 * 		scanf("%d%d%d%d",&p,&e,&i,&d);
 * 
 *		if(p == -1)break;
 *		day = d+1;
 *		
 *		while(1){
 *			day++;
 *			if((day-p)%23 == 0 && ((day-e)%28 ==0 && (day-i)%33 ==0))break;
 *		}
 *		printf("Case %d: the next triple peak occurs in %d days.\n",j,(day-d));
 *		j++;
 *	}
 *	return 0;
 *}
 * 
 */

import java.util.Scanner;

public class PKU1006 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int j = 1;
		int p,e,i,d,day;
		while(true){
			p = sc.nextInt();
			e = sc.nextInt();
			i = sc.nextInt();
			d = sc.nextInt();

			if(p == -1)break;
			day = d + 1;
			
			while(true){
				day++;
				if((day-p)%23 == 0 && ((day-e)%28 ==0 && (day-i)%33 ==0))break;
			}
			System.out.println("Case " + j + ": the next triple peak occurs in " + (day-d) + " days.");
			j++;
		}
	}
}
