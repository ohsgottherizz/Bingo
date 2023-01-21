import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][]hum=new int[5][5];
		int[][]com=new int[5][5];
		int i=0, j=0, n=0;
		//randomizing human array
		for(n=0;n<26;n++) {
			i = (int)(Math.random()*5);
			j = (int)(Math.random()*5);
			if(hum[i][j]==0) {
				hum[i][j]=n;
			}else {
				n--;
			}
	    }
		//randomizing computer array
		for(n=0;n<26;n++) {
			i = (int)(Math.random()*5);
			j = (int)(Math.random()*5);
			if(com[i][j]==0) {
				com[i][j]=n;
			}else {
				n--;
			}
	    }
		//getting input from the user
		while(true) {
			//printing human board
			System.out.println("Y o u r   B o a r d");
			for(i=0;i<5;i++) {
				for(j=0;j<5;j++) {
					if(hum[i][j]==0) {
						System.out.print("  @");
					}else {
						System.out.printf("%3d", hum[i][j]);
					}
				}
				System.out.println();
			}
			//printing computer board
			System.out.println("C o m p u t e r   B o a r d");
			for(i=0;i<5;i++) {
				for(j=0;j<5;j++) {
					if(com[i][j]==0) {
						System.out.print("  @");
					}else {
						System.out.printf("%3d", com[i][j]);
					}
				}
				System.out.println();
			}
			//user input
			System.out.print("Input(1): ");
			n=sc.nextInt();
			for(i=0;i<5;i++) {
				for(j=0;j<5;j++) {
					if(hum[i][j]==n) {
						hum[i][j]=0;
					}
					if(com[i][j]==n) {
						com[i][j]=0;
					}
				}
			}
			//computer picking it's number
			
		}//end of while(true)
		
		//is there bingo??
	}//end of main
}//end of class