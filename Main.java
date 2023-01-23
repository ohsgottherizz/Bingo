import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int[][]hum=new int[5][5];
		int[][]com=new int[5][5];
		int i=0, j=0, n=0;//foundation
		int nbingo=0, checka, checkb;//checking for bingo
		int mcount=0, c=0;
		
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
			for(i=0;i<5;i++) {
				for(j=0;j<5;j++) {
					if(hum[i][j]==com[2][2]) {
						hum[i][j]=0;
					}
				}
			}

			com[2][2]=0;

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

			//making n in both arrays 0

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

			//vertical check for human bingo

			for(i=0;i<5;i++) {
				a=b=0;
				for(j=0;j<5;j++) {
					if(hum[i][j]==0) {
						checka++;
					}
					if(hum[j][i]==0) {
						checkb++;
					}
				}
				if(checka==5) {
					nbingo++;
				}
				if(checkb==5) {
					nbingo++;
				}
			}

			checka=checkb=0;

			//diagnal check for human bingo

			for(i=0; i<5; i++)
			{
				if(hum[i][i]==0)
					checka++;
				if(hum[i][4-i]==0)
					checkb++;
			}

			if(checka==5)
				nbingo++;
			if(checkb==5)
				nbingo++;

			//print if bingo

			if(nbingo>=3) {
				System.out.println("You Win!\n");
				system.out.println("Computer's Bingo Board: ");
				
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
				break;
			}

			//computer picking it's number

			for(i=0;i<5;i++) {
				c=0;
				for(j=0;j<5;j++) {
					if(com[i][j]==0) {
						c++;
					}
				}
				if(mcount<c) {
					mcount=c;
				}  
				c=0;
				for(j=0;j<5;j++) { 
					if(com[j][i]==0) {  
						c++;
					}
				}
				if(mcount<c) {v 
					mcount=c
				}

			}

			//making n in both arrays 0

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

			//vertical check for computer bingo

			for(i=0;i<5;i++) {
				checka=checkb=0;
				for(j=0;j<5;j++) {
					if(com[i][j]==0) {
						checka++;
					}
					if(com[j][i]==0) {
						checkb++;
					}
				}
				if(checka==5) {
					nbingo++;
				}
				if(checkb==5) {
					nbingo++;
				}
			}

			checka=checkb=0;

			//diagnal check for computer bingo

			for(i=0;i<5;i++) {
				if(com[i][i]==0) {
					checka++;
				}
				if(com[i][4-i]==0) {
					checkb++;
				}
			}
			if(checka==5) {
				nbingo++;
			}
			if(checkb==5) {
				nbingo++;
			}

			//print if bingo

			if(nbingo>=3) {
				System.out.println("You Lose!\n");
				system.out.println("Computer's Bingo Board: ");
				
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
				break;
			}
		} //end of while(true)

	} //end of main
} //end of class