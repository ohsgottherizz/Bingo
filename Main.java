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
				checka=checkb=0;
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
				System.out.println("Computer's Bingo Board: ");
				
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

			int a, b, d, e, x, y, fa=0, fa1, fa2, ra;
			int result;
			int num[][]=new int[12][6];
            int most[][]=new int[12][5], re[]=new int[25];
			for(a=0; a<5; a++)
			{
				fa1=0;
				fa2=0;
				for(b=0; b<5; b++)
				{
					if(com[a][b]!=0)
					{
						num[fa][fa1]=com[a][b];
						fa1++;
					}
					if(com[b][a]!=0)
					{
						num[fa+1][fa2]=com[b][a];
						fa2++;
					}
				}
				num[fa][5]=fa1;
				num[fa+1][5]=fa2;
				fa+=2;
			}
			fa1=fa2=0;
			for(a=0; a<5; a++)
			{
				if(com[a][a]!=0)
				{
					num[fa][fa1]=com[a][a];
					fa1++;
				}
				if(com[a][4-a]!=0)
				{
					num[fa+1][fa2]=com[a][4-a];
					fa2++;
				}
			}
			num[fa][5]=fa1;
			num[fa+1][5]=fa2;

			x=5;
			for(a=0; a<12; a++)
			{
				if(num[a][5]==0)
					System.out.printf("\n");
				else if(num[a][5]<x)
					x=num[a][5];
			}
			y=0;
			for(a=0; a<12; a++)
			{
				if(num[a][5]==x)
				{
					for(b=0; b<5; b++)
						most[y][b]=num[a][b];
					y++;
				}
			}
			y=d=0;
			for(a=1; a<26; a++)
			{
				n=0;
				for(b=0; b<12; b++)
				{
					for(c=0; c<5; c++)
					{
						if(most[b][c]==a)
							n++;
					}
				}
				if(y==n)
				{
					re[d]=a;
					d++;
				}
				else if(n>y)
				{
					y=n;
					for(e=0; e<25; e++)
						re[e]=0;
					re[0]=a;
					d=1;
				}
			}
			ra=(int)(Math.random()*d);
			result=re[ra];

			//making n in both arrays 0

			for(i=0;i<5;i++) {
				for(j=0;j<5;j++) {
					if(hum[i][j]==result) {
						hum[i][j]=0;
					}
					if(com[i][j]==result) {
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
				System.out.println("Computer's Bingo Board: ");
				
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