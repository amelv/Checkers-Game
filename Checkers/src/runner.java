import java.util.Scanner;
public class runner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		board board = new board();
		int turnCount = 0, s = -1, cont = 1;
		boolean legal;
		while(cont==1)
		{
			board.print();
			System.out.println("\n");
			if(turnCount%2==0)
				System.out.println("---------------White's Move---------------");
			else
				System.out.println("---------------Black's Move---------------");
			legal=false;
			while(!legal)
			{
				s=-1;
				System.out.print("How many moves/jumps:");
				while(s<=0)
				{
					s=scan.nextInt();
					if(s<=0)
						System.out.print("Not a legal size \nHow many moves/jumps:");
				}
				if(s!=0)
				{
					int[][] moves = new int [s+1][2];

					System.out.print("What is your starting position:");
					moves[0][0]=scan.nextInt();
					moves[0][1]=scan.nextInt();
					for(int i=1;i<=s;i++)
					{
						System.out.print("What is move " + i + ":");
						moves[i][0]=scan.nextInt();
						moves[i][1]=scan.nextInt();
					}
					legal= board.isLegalMove(moves,turnCount%2);
					if(!legal)
						System.out.println("Not a legal move");
				}
			}
			turnCount++;
			cont = board.contCheck();
		}
		if(cont==2)
			System.out.println("White Wins");
		else
			System.out.println("Black Wins");
	}
}
